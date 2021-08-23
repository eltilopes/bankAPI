package com.example.bank.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Agency {
    @Column(nullable = false)
    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer digit;

    @ManyToOne()
    @JoinColumn()
    private Bank bank;

    public Agency() { }

    public Agency(String name, String number, Integer digit, Bank bank) {
        this.name = name;
        this.number = number;
        this.digit = digit;
        this.bank = bank;
    }
}