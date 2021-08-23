package com.example.bank.exception;

public class AccountEmptyException extends RuntimeException {

    public AccountEmptyException() {
        super("Conta empty!");
    }
}