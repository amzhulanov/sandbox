package com.probation.sandbox;

import com.probation.sandbox.proto.mapper.ConvertEntityToGrpc;
import com.probation.sandbox.proto.mapper.ConvertGrpcToEntity;
import com.probation.sandbox.services.ChildService;
import com.probation.sandbox.services.ParentService;
import io.grpc.Server;
import io.grpc.ServerInterceptors;
import io.grpc.netty.NettyServerBuilder;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SandboxServer {
    private static final int PERMIT_KEEP_ALIVE_TIME = 10;
    private static final int MAX_CONNECTION_IDLE = 30;
    private static final int KEEP_ALIVE_TIME = 10;
    private static final int KEEP_ALIVE_TIMEOUT = 20;

    @Value("${grpc.server.port}")
    public Integer port;

    private Server server;

    private final ParentService parentService;
    private final ChildService childService;
    private final ConvertEntityToGrpc convertEntityToGrpc;
    private final ConvertGrpcToEntity convertGrpcToEntity;

    public SandboxServer(ParentService parentService, ChildService childService, ConvertEntityToGrpc convertEntityToGrpc, ConvertGrpcToEntity convertGrpcToEntity) {
        this.parentService = parentService;
        this.childService = childService;
        this.convertEntityToGrpc = convertEntityToGrpc;
        this.convertGrpcToEntity = convertGrpcToEntity;
    }

    public void start() throws IOException {
        server.start();
    }

    /**
     * get the connect channel on the server side
     * @throws Exception
     */
    @PostConstruct
    public void postConstruct() throws Exception {
        server = NettyServerBuilder
                .forPort(port)
                .permitKeepAliveWithoutCalls(true)
                .maxConnectionIdle(MAX_CONNECTION_IDLE, TimeUnit.SECONDS)
                .keepAliveTime(KEEP_ALIVE_TIME, TimeUnit.SECONDS)
                .keepAliveTimeout(KEEP_ALIVE_TIMEOUT, TimeUnit.SECONDS)
                .permitKeepAliveTime(PERMIT_KEEP_ALIVE_TIME, TimeUnit.SECONDS)
                .addService(ServerInterceptors.intercept(new SandboxServiceImpl(childService, parentService, convertEntityToGrpc, convertGrpcToEntity)))
                .build();
        start();
    }
}
