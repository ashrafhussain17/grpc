package com.dohatec.grpc.client.service;

import com.dohatec.SupplyOrder;
import com.dohatec.SupplyOrderServiceGrpc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SupplyOrderService {

    @GrpcClient("grpc-dohatec-service")
    SupplyOrderServiceGrpc.SupplyOrderServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-dohatec-service")
    SupplyOrderServiceGrpc.SupplyOrderServiceFutureStub asynchronousClient;


    public Map<Descriptors.FieldDescriptor, Object> getSupplyOrderById(int id) throws JsonProcessingException {
        SupplyOrder supplyOrder = SupplyOrder.newBuilder().setSupplyOrderID(id).build();
        SupplyOrder clientSupplyOrder = synchronousClient.getSupplyOrder(supplyOrder);
        String s = clientSupplyOrder.getAllFields().toString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = mapper.writeValueAsString(s);
        return clientSupplyOrder.getAllFields();
    }
}
