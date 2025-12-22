package com.example.demospringwithsoap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/demospringwithsoap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PlusRequest")
    @ResponsePayload
    public PlusResponse plusRequest(@RequestPayload PlusRequest request) {
        PlusResponse response = new PlusResponse();

        response.setResult(request.getNumberA() + request.getNumberB());

        return response;
    }
}
