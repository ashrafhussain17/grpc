package com.dohatec.grpc.client.controller;

import com.dohatec.grpc.client.service.SupplyOrderService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class SupplyOrderController {

    private final SupplyOrderService supplyOrderService;

    @GetMapping("/supplyOrder/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable int id) throws JsonProcessingException {
        return supplyOrderService.getSupplyOrderById(id);
    }
}
