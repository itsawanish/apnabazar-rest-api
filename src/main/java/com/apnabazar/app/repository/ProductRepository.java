package com.apnabazar.app.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apnabazar.app.entity.ProductEntity;

@Repository
public class ProductRepository {
	@Autowired
    private SessionFactory sessionFactory;



    public void save(ProductEntity p) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public List<ProductEntity> search(String name) {
        Session s = sessionFactory.openSession();
        List<ProductEntity> list = s.createQuery(
                "from ProductEntity where name like :n",
                ProductEntity.class)
                .setParameter("n", "%" + name + "%")//
                .list();
        s.close();
        return list;
    }
}
