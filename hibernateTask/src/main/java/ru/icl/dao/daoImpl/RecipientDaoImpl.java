package ru.icl.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.icl.dao.RecipientDao;
import ru.icl.models.Recipient;
import ru.icl.models.User;

import java.util.List;

@Repository
public class RecipientDaoImpl implements RecipientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Recipient getRecipientById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Recipient recipient = session.load(Recipient.class, id);
        session.getTransaction().commit();
        return recipient;
    }

    @Override
    public List<Recipient> findAll(Long userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, userId);
        List<Recipient> recipientList = user.getRecipientList();
        session.getTransaction().commit();
        return recipientList;
    }


    @Override
    public void saveOrUpdateRecipient(Recipient recipient) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(recipient);
        session.getTransaction().commit();
    }

    @Override
    public void deleteRecipient(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Recipient recipient = session.load(Recipient.class, id);
        session.delete(recipient);
        session.getTransaction().commit();
    }
}