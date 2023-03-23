package com.example.rewardsrestfulapi.service;

import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import com.example.rewardsrestfulapi.model.Customer;

import java.util.List;

public interface CustomerService {
//    List<CustomerInfoEntity> findAll();
    Customer findByName(String name);
    Customer createCustomer(Customer customer);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(String name);
}
