package com.apnabazar.app.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apnabazar.app.entity.UserEntity;

@Repository 
public class UserRepository {
	
	@Autowired
    private SessionFactory sessionFactory;



    public void save(UserEntity user) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(user);
        tx.commit();
        s.close();
    }

    public UserEntity find(String username, String password) {
        Session s = sessionFactory.openSession();
        UserEntity user = s.createQuery(
                "from UserEntity where username=:u and password=:p",
                UserEntity.class)
                .setParameter("u", username)
                .setParameter("p", password)
                .uniqueResult();
        s.close();
        return user;
    }
}
