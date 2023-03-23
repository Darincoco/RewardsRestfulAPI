package com.example.rewardsrestfulapi.rest;

import com.example.rewardsrestfulapi.entity.CustomerInfoEntity;
import com.example.rewardsrestfulapi.exception.CustomerExistsException;
import com.example.rewardsrestfulapi.exception.CustomerNotFoundException;
import com.example.rewardsrestfulapi.exception.DBOpreationException;
import com.example.rewardsrestfulapi.model.Customer;
import com.example.rewardsrestfulapi.model.ResponseMessage;
import com.example.rewardsrestfulapi.service.CustomerService;
import com.example.rewardsrestfulapi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{name}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String name) {
        Customer customer = customerService.findByName(name);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found!");
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<ResponseMessage> createCustomer(@Validated @RequestBody Customer customer) {
        Customer thecustomer = customerService.findByName(customer.getName());
        if (thecustomer != null) {
            throw new CustomerExistsException("Customer already exists!");
        }

        customer.setId(0L);
        Customer savedcustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(new ResponseMessage("customer created!", savedcustomer), HttpStatus.CREATED);
    }

    @PutMapping("/customers/{name}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable("name") String name,
                                                    @Validated @RequestBody Customer customer){
        Customer thecustomer = customerService.findByName(name);
        if (thecustomer == null) {
            throw new CustomerNotFoundException("Customer not found!");
        }
        thecustomer = customerService.saveCustomer(customer);
        if (thecustomer == null) {
            throw new DBOpreationException("Customer update failed!");
        } else {
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
    }

    @DeleteMapping("/customers/{name}")
    public ResponseEntity<ResponseMessage> deleteCustomer(@PathVariable String name) {
        Customer customer = customerService.findByName(name);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        customerService.deleteCustomer(name);
        return new ResponseEntity<>(new ResponseMessage("customer has been deleted", customer), HttpStatus.OK);
    }





}
