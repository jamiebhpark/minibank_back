package com.example.minibank.controller;

import com.example.minibank.model.Transaction;
import com.example.minibank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestParam Long accountId) {
        return transactionService.getTransactions(accountId);
    }
}
