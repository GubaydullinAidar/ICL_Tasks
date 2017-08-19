package ru.icl.dao;

import ru.icl.models.Account;

public interface AccountDao {

    Account getAccountById(Long id);

    void updateAccount(Account account);
}
