package com.example.minibank.controller;

import com.example.minibank.model.Account;
import com.example.minibank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts(@RequestParam Long userId) {
        return accountService.getAccounts(userId);
    }
}
