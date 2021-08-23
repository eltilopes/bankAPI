package com.example.bank.service.impl;


import com.example.bank.entity.Bank;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service(value = "bancoService")
public class BancoServiceImpl implements BankService {

    @Autowired
    private BankRepository bancoRepository;

    @Override
    public Bank findById(long id) {
        Optional<Bank> optional = bancoRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

}
