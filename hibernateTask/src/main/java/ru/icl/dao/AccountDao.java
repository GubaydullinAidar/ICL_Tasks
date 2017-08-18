package ru.icl.dao;

import ru.icl.models.Account;

public interface AccountDao {

    Account findByAccountNumber(int accountNumber);

    void save(Account account);
}
