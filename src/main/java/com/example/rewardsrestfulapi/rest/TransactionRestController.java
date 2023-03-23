package com.example.rewardsrestfulapi.rest;

import com.example.rewardsrestfulapi.exception.DBOpreationException;
import com.example.rewardsrestfulapi.model.ResponseMessage;
import com.example.rewardsrestfulapi.model.Transaction;
import com.example.rewardsrestfulapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api")
public class TransactionRestController {

    private TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/{name}")
    public ResponseEntity<List<Transaction>> getTransaction(@PathVariable String name) {
        List<Transaction> transactions = transactionService.getTransactionsByName(name);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("/transactions")
    public ResponseEntity<ResponseMessage> addTransaction(@Validated @RequestBody Transaction transaction) {
        Transaction thetransaction = transactionService.addTransaction(transaction);
        if (thetransaction == null) {
            throw new DBOpreationException("Add transaction failed!");
        } else {
            return new ResponseEntity<>(
                    new ResponseMessage("Transaction added!", transaction), HttpStatus.CREATED);
        }
    }

}
