package com.dohatec.grpc.client.config;

import com.dohatec.BookAuthorServiceGrpc;
import com.dohatec.LaptopServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationGrpc {
    @Value("${grpc.client.grpc-dohatec-service1.address}")
    private String service1Address;

    @Value("${grpc.client.grpc-dohatec-service2.address}")
    private String service2Address;

    @Bean(name = "service1Stub")
    public BookAuthorServiceGrpc.BookAuthorServiceBlockingStub service1Stub() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(service1Address).usePlaintext().build();
        return BookAuthorServiceGrpc.newBlockingStub(channel);
    }

    @Bean(name = "service2Stub")
    public LaptopServiceGrpc.LaptopServiceBlockingStub service2Stub() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(service2Address).usePlaintext().build();
        return LaptopServiceGrpc.newBlockingStub(channel);
    }
}
