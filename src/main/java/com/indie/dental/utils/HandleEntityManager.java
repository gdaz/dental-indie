package com.indie.dental.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class HandleEntityManager {

    @Autowired
    private EntityManager entityManager;

    public Session getSessionFactory() {
        return entityManager.unwrap(Session.class);
    }
}
