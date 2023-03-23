package com.example.rewardsrestfulapi.service;

import com.example.rewardsrestfulapi.dao.CustomerDAO;
import com.example.rewardsrestfulapi.dao.CustomerDAOImpl;
import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import com.example.rewardsrestfulapi.model.Customer;
import com.example.rewardsrestfulapi.util.EntityVoConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findByName(String name) {
        CustomerInfoEntity customerInfoEntity = customerDAO.findByName(name);
        return EntityVoConverter.convertEntityToVo(customerInfoEntity);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Transactional
    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerInfoEntity customerInfoEntity = customerDAO.saveCustomer(EntityVoConverter.convertVoToEntity(customer));
        return EntityVoConverter.convertEntityToVo(customerInfoEntity);
    }

    @Transactional
    @Override
    public void deleteCustomer(String name) {
        customerDAO.deleteCustomer(name);
    }
}
