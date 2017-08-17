package ru.icl.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;


}
