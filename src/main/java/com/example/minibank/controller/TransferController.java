package com.example.minibank.controller;

import com.example.minibank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromAccountId, @RequestParam String toAccountNumber, @RequestParam Double amount) {
        return transferService.transfer(fromAccountId, toAccountNumber, amount);
    }
}
