package com.example.rewardsrestfulapi.dao;

import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import com.example.rewardsrestfulapi.model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<CustomerInfoEntity> findAll();
    CustomerInfoEntity findByName(String name);
    CustomerInfoEntity saveCustomer(CustomerInfoEntity customerInfoEntity);
    void deleteCustomer(String name);
}
