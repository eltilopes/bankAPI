package com.example.bank.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {
    @Column(nullable = false)
    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer digit;

    @ManyToOne()
    @JoinColumn
    private Agency agency;

    public Account() { }

    public Account(String number, Integer digit, Double balance, Agency agency) {
        this.number = number;
        this.digit = digit;
        this.balance = balance;
        this.agency = agency;
    }
}