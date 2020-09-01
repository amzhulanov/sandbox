package com.probation.sandbox;

import com.probation.sandbox.entities.Parent;
import com.probation.sandbox.services.ParentService;
import grpc.Email;
import grpc.ParentId;
import grpc.ParentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import grpc.APIResponse;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest()
@Slf4j
public class ParentLifeCycleTest {
    private final String DEF_EMAIL="1@1.ru";

    @Value("${grpc.server}")
    public String host;
    @Value("${grpc.server.port}")
    public Integer port;

    private ManagedChannel channel;
    private ParentServiceGrpc.ParentServiceBlockingStub stub;
    private APIResponse apiResponse;
    private Parent newParent=new Parent(DEF_EMAIL,"hello","hello",TimeZone.getDefault());

    private ParentService parentService;

    @Autowired
    public ParentLifeCycleTest(ParentService parentService) {
        this.parentService = parentService;
    }

    @BeforeEach
    public void openChannel() {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        stub = ParentServiceGrpc.newBlockingStub(channel);

        if (parentService.findParentByEmail(DEF_EMAIL)==null){
            Long idSavedParent=parentService.saveParent(newParent);
            
            log.info("В базу добавлен тестовый пользователь " + idSavedParent);
        }
        else{
            log.info("В базе уже есть такой пользователь ");
        }
    }

    @AfterEach
    public void shutdownChannel() {
        channel.shutdown();
    }

    @Test
    public void testFindParentByEmail(){
        grpc.ParentResponse parentResponse;
        parentResponse=stub.findParentByEmail(
                Email.newBuilder()
                .setEmail(DEF_EMAIL)
                .build());
        log.info("Find parent id="+parentResponse);
        assertTrue(parentResponse.getSerializedSize()>0);

    }

    @Test
    public void testSave(){
        grpc.ParentId grpcParentId;
        grpcParentId=stub.save(
                grpc.Parent.newBuilder()
                .setEmail("hello@hello.ru")
                .setName(newParent.getName())
                .setPassword(newParent.getPassword())
                .setTimeZone(newParent.getTimeZone().toString())
                .build());
        log.info("Saved Parent id="+grpcParentId);
        assertTrue(grpcParentId.getId()>0);
    }
}
