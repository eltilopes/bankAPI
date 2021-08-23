package com.example.bank.service.impl;


import com.example.bank.entity.Account;
import com.example.bank.exception.AccountEmptyException;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        Optional<Account> optionalConta = accountRepository.findById(id);
        if(!optionalConta.isPresent()){
            throw new AccountEmptyException();
        }
        return  optionalConta.get();
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Double getBalance(Long accountId){
        Account account = findById(accountId);
        return account.getBalance();
    }

}
