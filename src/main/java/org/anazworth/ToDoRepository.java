package org.anazworth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class ToDoRepository implements ToDoStorage {

    private final SessionFactory sessionFactory;

    public ToDoRepository() {
        sessionFactory = new org.hibernate.cfg.Configuration()
                .configure()
                .buildSessionFactory();
    }
    @Override
    public List<ToDoItem> getAllItems() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            var items = session.createQuery("from ToDoItem", ToDoItem.class).list();
            session.getTransaction().commit();
            return items;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addItem(ToDoItem item) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completeItem(int id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            var item = session.get(ToDoItem.class, id);
            item.setCompleted(true);
            item.setDateCompleted(new Date().toString());
            session.merge(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(int id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            var item = session.get(ToDoItem.class, id);
            session.remove(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<ToDoItem> getAllUncompletedItems() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            var items = session.createQuery("from ToDoItem where completed = false", ToDoItem.class).list();
            session.getTransaction().commit();
            return items;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public List<ToDoItem> getAllItems() {
//        try {
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            var items = session.createQuery("from ToDoItem where completed = true", ToDoItem.class).list();
//            session.getTransaction().commit();
//            return items;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
