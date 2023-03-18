package com.dohatec.grpc.client.controller;

import com.dohatec.Filter;
import com.dohatec.SearchLaptopRequest;
import com.dohatec.grpc.client.service.PCService;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class PCController {
    final PCService pcService;

    @GetMapping("/search/{request}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable Integer request) {
        SearchLaptopRequest searchLaptopRequest = SearchLaptopRequest.newBuilder().setFilter(Filter.newBuilder().setMinCpuCores(request).build()).build();
        return pcService.searchLaptop(searchLaptopRequest);
    }
}
