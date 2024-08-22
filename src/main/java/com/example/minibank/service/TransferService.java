package com.example.minibank.service;

import com.example.minibank.model.Account;
import com.example.minibank.model.Transaction;
import com.example.minibank.repository.AccountRepository;
import com.example.minibank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public String transfer(Long fromAccountId, String toAccountNumber, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From account not found"));
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new RuntimeException("To account not found"));

        if (fromAccount.getBalance() < amount) {
            return "Insufficient funds";
        }

        // 이체
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // 트랜잭션 기록
        Transaction fromTransaction = new Transaction();
        fromTransaction.setAmount(-amount);
        fromTransaction.setAccount(fromAccount);
        fromTransaction.setDescription("Transfer to " + toAccountNumber);
        transactionRepository.save(fromTransaction);

        Transaction toTransaction = new Transaction();
        toTransaction.setAmount(amount);
        toTransaction.setAccount(toAccount);
        toTransaction.setDescription("Transfer from " + fromAccount.getAccountNumber());
        transactionRepository.save(toTransaction);

        return "Transfer successful";
    }
}
