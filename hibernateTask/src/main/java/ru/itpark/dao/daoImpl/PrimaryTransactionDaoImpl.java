package ru.itpark.dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itpark.dao.PrimaryTransactionDao;
import ru.itpark.models.PrimaryAccount;
import ru.itpark.models.PrimaryTransaction;

import java.util.List;

@Repository
public class PrimaryTransactionDaoImpl implements PrimaryTransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(PrimaryTransaction primaryTransaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(primaryTransaction);
        session.getTransaction().commit();
    }

    @Override
    public List<PrimaryTransaction> findAll(Integer accountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(PrimaryAccount.class);
        userCriteria.add(Restrictions.eq("accountNumber", accountNumber));
        PrimaryAccount primaryAccount = (PrimaryAccount) userCriteria.uniqueResult();
        List<PrimaryTransaction> primaryTransactionList = primaryAccount.getPrimaryTransactionList();
        session.getTransaction().commit();
        return primaryTransactionList;
    }

    @Override
    public List<PrimaryTransaction> findAllOrderByAmount() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(PrimaryTransaction.class);
        List<PrimaryTransaction> primaryTransactionList = criteria.addOrder(Order.asc("amount")).list();
        session.close();
        return primaryTransactionList;
    }


}
