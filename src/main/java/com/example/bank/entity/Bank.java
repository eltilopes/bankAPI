package com.example.bank.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Bank {
    @Column(nullable = false)
    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    public Bank() { }

    public Bank(String code, String name) {
        this.code = code;
        this.name = name;
    }
}