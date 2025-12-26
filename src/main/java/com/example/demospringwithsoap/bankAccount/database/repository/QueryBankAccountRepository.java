package com.example.demospringwithsoap.bankAccount.database.repository;

import com.example.demospringwithsoap.BankAccount;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class QueryBankAccountRepository {
    private static final Map<String, BankAccount> bankAccounts = new HashMap<>();

    static {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setAccountNumber("MX-001");
        bankAccount1.setAccountHolder("Juan Pérez");
        bankAccount1.setBalance(1500.42);

        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setAccountNumber("MX-002");
        bankAccount2.setAccountHolder("María López");
        bankAccount2.setBalance(53200);

        BankAccount bankAccount3 = new BankAccount();
        bankAccount3.setAccountNumber("MX-003");
        bankAccount3.setAccountHolder("Carlos García");
        bankAccount3.setBalance(0.00);

        bankAccounts.put(bankAccount1.getAccountNumber(), bankAccount1);
        bankAccounts.put(bankAccount2.getAccountNumber(), bankAccount2);
        bankAccounts.put(bankAccount3.getAccountNumber(), bankAccount3);
    }

    public BankAccount findBankAccount(String accountNumber) {
        Assert.notNull(accountNumber, "Account number must not be null");
        return bankAccounts.get(accountNumber);
    }
}
