package com.probation.sandbox;

import com.probation.sandbox.entities.Child;
import com.probation.sandbox.entities.Parent;
import com.probation.sandbox.proto.mapper.ConvertEntityToGrpc;
import com.probation.sandbox.proto.mapper.ConvertGrpcToEntity;
import com.probation.sandbox.services.ChildService;
import grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import com.probation.sandbox.services.ParentService;

import java.util.List;

@GrpcService
@Slf4j
public class SandboxServiceImpl extends ParentServiceGrpc.ParentServiceImplBase{
    private final String NOT_FOUND ="Not Found";
    private APIResponse apiResponse;
    private final ChildService childService;
    private final ParentService parentService;
    private final ConvertEntityToGrpc convertEntityToGrpc;
    private final ConvertGrpcToEntity convertGrpcToEntity;


    @Autowired
    public SandboxServiceImpl(ChildService childService, ParentService parentService, ConvertEntityToGrpc convertEntityToGrpc, ConvertGrpcToEntity convertGrpcToEntity) {
        this.childService = childService;
        this.parentService = parentService;
        this.convertEntityToGrpc = convertEntityToGrpc;
        this.convertGrpcToEntity = convertGrpcToEntity;
    }

    /**
     * заворачиваю List<Child> в GRPC и передаю в ответ
     * @param  - родитель по которому осуществляется поиск детей
     * @param responseObserver
     */
    public void findChildByParent(grpc.ParentId grpcParent, StreamObserver<ListChild> responseObserver){

        List<Child> childList=childService.getAllChildsByParent(grpcParent);

        ListChild.Builder builder=grpc.ListChild.newBuilder();
        childList.stream().forEach((ch)->builder.addChild(convertEntityToGrpc.childToGrpc(ch)));

        //apiResponse = APIResponse.newBuilder().addRepeatedField(childList).build();//setIdTask(convertEntityToGrpc.javaUUIDToGrpcUUID(id_task)).build();
        grpc.ListChild listGrpcChild=builder.build();
        responseObserver.onNext(listGrpcChild);
        responseObserver.onCompleted();
    }

    /**
     * Переопределяю метод поиска родителя по электронной почте.
     * Обращаюсь на уровень сервисов, за данными.
     * Преобразовыываю данные в формат GRPC и отправляю ответ
     * @param grpcEmail - параметр полученный контроллером, используется для поиска Parent
     * @param responseObserver - интерфейс StreamObserver
     */
    @Override
    public void findParentByEmail(Email grpcEmail, StreamObserver<ParentResponse> responseObserver){
        Parent parent=parentService.findParentByEmail(grpcEmail.getEmail().toString());

        grpc.ParentResponse grpcParentResponse;
        if (parent!=null) {
            log.info("Found Parent name="+parent.getName());
            grpcParentResponse = grpc.ParentResponse.newBuilder()
                    .setEmail(parent.getEmail())
                    .setTimeZone(parent.getTimeZone().toString())
                    .setName(parent.getName())
                    .build();
        }else
        { log.info("Parent not found");
            grpcParentResponse = grpc.ParentResponse.newBuilder()
                .setEmail(NOT_FOUND)
                .setTimeZone(NOT_FOUND)
                .setName(NOT_FOUND)
                .build();
        }
        responseObserver.onNext(grpcParentResponse);
        responseObserver.onCompleted();
    }

    /**
     *Метод получает объект grpc.Parent
     * Сохраняет его в базе данных и возвращает ID сохранённого Parent
     * @param grpcParent - объект Parent для сохранения в базе данных
     * @param responseObserver - интерфейс StreamObserver
     */

    @Override
    public void save(grpc.Parent grpcParent, StreamObserver<grpc.ParentId> responseObserver){
        Long id=parentService.saveParent(convertGrpcToEntity.grpcToEntity(grpcParent));
        log.info("Parent added id="+id);
        grpc.ParentId grpcParentId;
        grpcParentId=grpc.ParentId.newBuilder()
                .setId(Math.toIntExact(id))
                .build();
        responseObserver.onNext(grpcParentId);
        responseObserver.onCompleted();
    }

}
