package com.example.demospringwithsoap.bankAccount.infrastructure.endpoint;

import com.example.demospringwithsoap.BankAccount;
import com.example.demospringwithsoap.GetBankAccountRequest;
import com.example.demospringwithsoap.GetBankAccountResponse;
import com.example.demospringwithsoap.bankAccount.database.repository.QueryBankAccountRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BankAccountEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/demospringwithsoap";

    private final QueryBankAccountRepository queryBankAccountRepository; // Dependence

    // DI
    public BankAccountEndpoint(QueryBankAccountRepository queryBankAccountRepository) {
        this.queryBankAccountRepository = queryBankAccountRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBankAccountRequest")
    @ResponsePayload
    public GetBankAccountResponse getBankAccount(@RequestPayload GetBankAccountRequest request) {
        GetBankAccountResponse response = new GetBankAccountResponse();
        BankAccount bankAccount = queryBankAccountRepository.findBankAccount(request.getAccountNumber());
        response.setBankAccount(bankAccount);

        return response;
    }
}
