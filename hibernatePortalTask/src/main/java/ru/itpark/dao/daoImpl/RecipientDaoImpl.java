package ru.itpark.dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itpark.dao.RecipientDao;
import ru.itpark.models.Recipient;
import ru.itpark.models.User;

import java.util.List;

@Repository
public class RecipientDaoImpl implements RecipientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Recipient> findAll(String username) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(User.class);
        userCriteria.add(Restrictions.eq("username", username));
        User user = (User) userCriteria.uniqueResult();
        List<Recipient> recipientList = user.getRecipientList();
        session.getTransaction().commit();
        return recipientList;
    }

    @Override
    public Recipient findByAccountNumber(int recipientAccountNumber) {
        Session session = sessionFactory.openSession();
        Criteria userCriteria = session.createCriteria(Recipient.class);
        userCriteria.add(Restrictions.eq("recipientAccountNumber", recipientAccountNumber));
        Recipient recipient = (Recipient) userCriteria.uniqueResult();
        session.close();
        return recipient;
    }

    public void deleteByAccountNumber(int recipientAccountNumber) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(Recipient.class);
        userCriteria.add(Restrictions.eq("recipientAccountNumber", recipientAccountNumber));
        Recipient recipient = (Recipient) userCriteria.uniqueResult();
        session.delete(recipient);
        session.getTransaction().commit();
    }

    @Override
    public Recipient save(Recipient recipient) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(recipient);
        session.getTransaction().commit();
        return recipient;
    }
}
