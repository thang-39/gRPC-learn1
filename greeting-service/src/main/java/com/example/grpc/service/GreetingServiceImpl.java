package com.example.grpc.service;

import com.example.grpc.GreetingRequest;
import com.example.grpc.GreetingResponse;
import com.example.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
    public void greeting(GreetingRequest request,
                         StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received your " + message + ".Hello From Server. ")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
