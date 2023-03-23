package com.example.rewardsrestfulapi.util;

import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import com.example.rewardsrestfulapi.entity.TransactionEntity;
import com.example.rewardsrestfulapi.model.Customer;
import com.example.rewardsrestfulapi.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EntityVoConverter {
    public static Customer convertEntityToVo(CustomerInfoEntity entity) {
        if (entity == null) return null;

        Customer customer = new Customer();
        customer.setId(entity.getId());
        customer.setName(entity.getName());
        customer.setEmail(entity.getEmail());
        customer.setPassword(entity.getPassword());
        return customer;
    }

    public static CustomerInfoEntity convertVoToEntity(Customer customer) {
        if (customer == null) return null;

        return new CustomerInfoEntity(customer.getId(), customer.getName(),
                customer.getEmail(), customer.getPassword());
    }

    public static Transaction convertEntityToVo(TransactionEntity transactionEntity) {
        if (transactionEntity == null) return null;
        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setCustomerName(transactionEntity.getCustomerName());
        transaction.setTransactionMonth(transactionEntity.getTransactionMonth());
        transaction.setAmount(transactionEntity.getAmount());

        return transaction;
    }

    public static  TransactionEntity convertVoToEntity(Transaction transaction) {
        if (transaction == null) return null;
        return new TransactionEntity(transaction.getId(), transaction.getCustomerName(),
                transaction.getTransactionMonth(), transaction.getAmount());
    }

    public static List<Transaction> ConvertTransactionEntityToTransaction(List<TransactionEntity> transactionEntities) {
        List<Transaction> result = new ArrayList<>();
        for (TransactionEntity t: transactionEntities) {
            result.add(convertEntityToVo(t));
        }
        return result;
    }
}
