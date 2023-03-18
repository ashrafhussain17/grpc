package com.dohatec.grpc.server;

import com.dohatec.SupplyOrder;
import com.dohatec.SupplyOrderServiceGrpc;
import com.dohatec.TempDB;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SupplyOrderService extends SupplyOrderServiceGrpc.SupplyOrderServiceImplBase {
    @Override
    public void getSupplyOrder(SupplyOrder request, StreamObserver<SupplyOrder> responseObserver) {
        TempDB.getSupplyOrderList()
                .stream()
                .filter(supplyOrder -> supplyOrder.getSupplyOrderID() == request.getSupplyOrderID())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
