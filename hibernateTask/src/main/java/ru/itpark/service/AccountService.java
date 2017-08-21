package ru.itpark.service;

import ru.itpark.models.PrimaryAccount;

import java.security.Principal;

public interface AccountService {

    PrimaryAccount createPrimaryAccount();

    void deposit(double amount, Principal principal);

    void withdraw(double amount, Principal principal);

}
