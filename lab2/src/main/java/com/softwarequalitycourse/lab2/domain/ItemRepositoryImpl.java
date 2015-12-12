package com.softwarequalitycourse.lab2.domain;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;


import java.util.List;

/**
 * Created by sasha on 11/22/15.
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createItem(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }
    @Override
    public void createItems(List<Item> items) {
        Session session =sessionFactory.getCurrentSession();
        items.stream().forEach(item -> session.save(item));
    }

    @Override
    public Item getItem(int id) {
        return (Item)  sessionFactory.getCurrentSession().get(Item.class,id);
    }

    @Override
    public void removeItem(Item item) {
        sessionFactory.getCurrentSession().delete(item);
    }

    @Override
    public void editItem(Item item) {
        sessionFactory.getCurrentSession().update(item);
    }

    @Override
    public List<Item> getAllItems() {
        return sessionFactory.getCurrentSession().createQuery( "FROM Item" ).list();
    }
}
