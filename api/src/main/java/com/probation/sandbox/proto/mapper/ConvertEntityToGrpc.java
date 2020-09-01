package com.probation.sandbox.proto.mapper;

import org.springframework.stereotype.Component;
import com.probation.sandbox.entities.Child;

@Component
public class ConvertEntityToGrpc {

    public grpc.Child childToGrpc(Child child){
        return grpc.Child.newBuilder()
                .setName(child.getName())
                .setBirthday(child.getBirthday().toString())
                .setGender(child.getGender().toString())
                .setTariff(child.getTariff())
                .build();
    }
}
