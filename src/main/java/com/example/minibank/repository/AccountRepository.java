package com.example.minibank.repository;

import com.example.minibank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
    Optional<Account> findByAccountNumber(String accountNumber);

}
