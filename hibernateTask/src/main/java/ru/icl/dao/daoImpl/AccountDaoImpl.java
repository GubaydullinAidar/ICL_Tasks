package ru.icl.dao.daoImpl;

import org.hibernate.Session;
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
    public Account getAccountById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = session.load(Account.class, id);
        session.getTransaction().commit();
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();
    }
}
