package com.example.bank.controller;

import com.example.bank.entity.Bank;
import com.example.bank.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * The BankController controls all calls to the entity Bank.
 *
 * @author  Elton Lopes
 * @version 1.0
 * @since   2021-08-21
 */
@RestController
@RequestMapping("banco")
class BankController {

    private static final Logger log = LoggerFactory.getLogger(BankController.class);

    private final BankRepository bancoRepository;

    BankController( BankRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    @GetMapping()
    List<Bank> allBanks() {
        log.info("GET : allBanks");
        return bancoRepository.findAll();
    }


}