package ru.icl.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.icl.dao.UserDao;
import ru.icl.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}
