package com.example.rewardsrestfulapi.service;

import com.example.rewardsrestfulapi.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsByName(String name);
    List<Transaction> getTransactionsByNameMonth(String name, int month);
    Transaction addTransaction(Transaction transaction);
}
