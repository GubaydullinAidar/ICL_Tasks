package ru.icl.service;

import ru.icl.models.Account;

import java.security.Principal;

public interface AccountService {

    Account createAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);

}
