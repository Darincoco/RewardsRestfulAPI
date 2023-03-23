package com.example.rewardsrestfulapi.dao;

import com.example.rewardsrestfulapi.entity.TransactionEntity;

import java.util.List;

public interface TransactionDAO {

    List<TransactionEntity> getTransactionsByName(String name);

    List<TransactionEntity> getTransactionsByNameMonth(String name, int month);

    TransactionEntity addTransaction(TransactionEntity transaction);

    void deleteTransaction(String name);
}
