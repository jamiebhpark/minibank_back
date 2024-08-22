package com.example.minibank.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date date = new Date();

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
