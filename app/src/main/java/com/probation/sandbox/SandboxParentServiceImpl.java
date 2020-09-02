package com.probation.sandbox;

import com.probation.sandbox.entities.Parent;
import com.probation.sandbox.proto.mapper.ConvertEntityToGrpc;
import com.probation.sandbox.proto.mapper.ConvertGrpcToEntity;
import grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import com.probation.sandbox.services.ParentService;


/**
 * Класс для обработки запросов, поступающих на сервис ParentService
 */
@GrpcService
@Slf4j
public class SandboxParentServiceImpl extends ParentServiceGrpc.ParentServiceImplBase{
    private final String NOT_FOUND ="Not Found";

    private final ParentService parentService;
    private final ConvertEntityToGrpc convertEntityToGrpc;
    private final ConvertGrpcToEntity convertGrpcToEntity;


    @Autowired
    public SandboxParentServiceImpl(ParentService parentService, ConvertEntityToGrpc convertEntityToGrpc, ConvertGrpcToEntity convertGrpcToEntity) {
        this.parentService = parentService;
        this.convertEntityToGrpc = convertEntityToGrpc;
        this.convertGrpcToEntity = convertGrpcToEntity;
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
