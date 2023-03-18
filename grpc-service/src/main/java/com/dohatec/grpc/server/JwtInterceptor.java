package com.dohatec.grpc.server;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.stereotype.Component;

@Component
@GrpcGlobalServerInterceptor
public class JwtInterceptor implements ServerInterceptor {

    private static final Metadata.Key<String> JWT_TOKEN_KEY =
            Metadata.Key.of("jwt_token", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        String jwtToken = headers.get(JWT_TOKEN_KEY);
        // Do something with the JWT token, e.g. validate it

        return next.startCall(call, headers);
    }
}
