package com.example.minibank.service;

import com.example.minibank.model.Account;
import com.example.minibank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts(Long userId) {
        return accountRepository.findByUserId(userId);
    }
}
