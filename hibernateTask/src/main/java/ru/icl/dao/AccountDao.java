package ru.icl.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.icl.models.Account;

@Component
public interface AccountDao {

    Account findByAccountNumber(int accountNumber);

    void save(Account account);
}
