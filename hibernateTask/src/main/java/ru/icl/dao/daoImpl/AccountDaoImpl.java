package ru.icl.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.icl.dao.AccountDao;
import ru.icl.models.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account findByAccountNumber(int accountNumber) {
        return null;
    }

    @Override
    public void save(Account account) {

    }
}
