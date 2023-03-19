package com.dohatec.grpc.client.service;

import com.dohatec.BookAuthorServiceGrpc;
import com.dohatec.LaptopServiceGrpc;
import com.dohatec.SearchLaptopRequest;
import com.dohatec.SearchLaptopResponse;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class PCService {
    @GrpcClient("grpc-dohatec-service2")
    LaptopServiceGrpc.LaptopServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-dohatec-service2")
    LaptopServiceGrpc.LaptopServiceStub asynchronousClient;


    public Map<Descriptors.FieldDescriptor, Object> searchLaptop(SearchLaptopRequest request) {
        Map<Descriptors.FieldDescriptor, Object> returnValue = new HashMap<>();
        Iterator<SearchLaptopResponse> searchLaptopResponseIterator = synchronousClient.searchLaptop(request);
        return  searchLaptopResponseIterator.next().getAllFields();
    }
}
