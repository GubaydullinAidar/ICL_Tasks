package ru.icl.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.icl.dao.TransactionDao;
import ru.icl.models.Transaction;
import ru.icl.models.User;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> findAll(Long userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, userId);
        List<Transaction> transactionList = user.getAccount().getTransactionList();
        session.getTransaction().commit();
        return transactionList;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(transaction);
        session.getTransaction().commit();
    }

    @Override
    public void deleteTransaction(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.load(Transaction.class, id);
        session.delete(transaction);
        session.getTransaction().commit();
    }


}
