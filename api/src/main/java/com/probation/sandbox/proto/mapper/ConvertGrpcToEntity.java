package com.probation.sandbox.proto.mapper;

import com.probation.sandbox.entities.Parent;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
public class ConvertGrpcToEntity {

    public Parent grpcToEntity(grpc.Parent grpcParent){
        return new Parent(grpcParent.getEmail() ,grpcParent.getName(),grpcParent.getPassword(), TimeZone.getTimeZone(grpcParent.getTimeZone()) );
    }

}
