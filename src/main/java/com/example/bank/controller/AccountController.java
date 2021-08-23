package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.exception.AccountEmptyException;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The AccountController controls all calls to the entity Account.
 *
 * @author  Elton Lopes
 * @version 1.0
 * @since   2021-08-21
 */
@RestController
@RequestMapping("conta")
class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    private final AccountRepository accountRepository;

    AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping()
    List<Account> allAccounts() {
        log.info("GET : allAccounts");
        return accountService.findAll();
    }

    /**
     * This is the getAccount method.
     * @param "accountId".
     * @return "Account".
     * @exception AccountEmptyException .
     */
    @GetMapping("/{accountId}")
    Account getAccount(@PathVariable Long accountId, HttpServletResponse response) {
        log.info("GET : getAccount");
        try {
            return accountService.findById(accountId);
        }catch (AccountEmptyException accountEmptyException){
            response.setStatus( HttpStatus.NO_CONTENT.value());
        }
        return null;
    }

    /**
     * This is the getBalance method.
     * @param "accountId".
     * @return "balance".
     * @exception AccountEmptyException .
     */
    @GetMapping("/saldo/{accountId}")
    Double getBalance(@PathVariable Long accountId, HttpServletResponse response) {
        log.info("GET : getBalance");
        try {
            return accountService.getBalance(accountId);
        }catch (AccountEmptyException accountEmptyException){
            response.setStatus( HttpStatus.NO_CONTENT.value());
        }
        return null;
    }
}