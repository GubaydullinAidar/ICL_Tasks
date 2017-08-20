package ru.itpark.dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itpark.dao.UserDao;
import ru.itpark.models.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {

        Session session = sessionFactory.openSession();
        Criteria userCriteria = session.createCriteria(User.class);
        userCriteria.add(Restrictions.eq("username", username));
        User user = (User) userCriteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Criteria userCriteria = session.createCriteria(User.class);
        userCriteria.add(Restrictions.eq("email", email));
        User user = (User) userCriteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
}
