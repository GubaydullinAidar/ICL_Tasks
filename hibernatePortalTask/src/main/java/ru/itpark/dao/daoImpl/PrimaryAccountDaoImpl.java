package ru.itpark.dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itpark.dao.PrimaryAccountDao;
import ru.itpark.models.PrimaryAccount;

import java.util.List;

@Repository
public class PrimaryAccountDaoImpl implements PrimaryAccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PrimaryAccount findByAccountNumber(Integer accountNumber) {
        Session session = sessionFactory.openSession();
        Criteria userCriteria = session.createCriteria(PrimaryAccount.class);
        userCriteria.add(Restrictions.eq("accountNumber", accountNumber));
        PrimaryAccount primaryAccount = (PrimaryAccount) userCriteria.uniqueResult();
        session.close();
        return primaryAccount;
    }

    @Override
    public PrimaryAccount save(PrimaryAccount primaryAccount) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(primaryAccount);
        session.getTransaction().commit();
        return primaryAccount;
    }

    @Override
    public Integer getMaxAccountNumber() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select max(accountNumber) from PrimaryAccount");
        Integer max =(Integer) query.list().get(0);
        session.close();
        return max;
    }
}
