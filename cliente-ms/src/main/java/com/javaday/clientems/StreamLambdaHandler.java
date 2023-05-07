package com.javaday.clientems;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambdaHandler implements RequestStreamHandler {
    //    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            SpringBootLambdaContainerHandler
                    .getAwsProxyHandler(ClienteMsApplication.class);
            // If you are using HTTP APIs with the version 2.0 of the proxy model, use the getHttpApiV2ProxyHandler
            // method: handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(Application.class);
        } catch (ContainerInitializationException e) {

            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public StreamLambdaHandler() throws ContainerInitializationException {
//        handler = (SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>) new SpringBootProxyHandlerBuilder()
//                .defaultProxy()
//                .asyncInit()
//                .buildAndInitialize();
//        handler = (SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>) new SpringBootProxyHandlerBuilder()
//                .defaultProxy()
//                .asyncInit()
//                .springBootApplication(ClienteMsApplication.class)
//                .buildAndInitialize();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}
//com.javaday.clientems.StreamLambdaHandler.handleRequest