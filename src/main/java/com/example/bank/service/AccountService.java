package com.example.bank.service;

import com.example.bank.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Account findById(Long accountId);
    List<Account> findAll();
    Double getBalance(Long accountId);
}
