package com.probation.sandbox;

import com.probation.sandbox.entities.Child;
import com.probation.sandbox.proto.mapper.ConvertEntityToGrpc;
import com.probation.sandbox.proto.mapper.ConvertGrpcToEntity;
import com.probation.sandbox.services.ChildService;
import grpc.ChildServiceGrpc;
import grpc.ListChild;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Класс для обработки запросов, поступающих на сервис ChildService
 */

@GrpcService
@Slf4j
public class SandboxChildServiceImpl extends ChildServiceGrpc.ChildServiceImplBase {
    private final ChildService childService;
    private final ConvertEntityToGrpc convertEntityToGrpc;
    private final ConvertGrpcToEntity convertGrpcToEntity;

    @Autowired
    public SandboxChildServiceImpl(ChildService childService, ConvertEntityToGrpc convertEntityToGrpc, ConvertGrpcToEntity convertGrpcToEntity) {
        this.childService = childService;
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
}
