package com.sopra.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sopra.BookStore.App;
import com.sopra.BookStore.Inventory;


@Repository
public class BookStoreRepository implements ObjectRepository<Inventory>{

	Inventory in = new Inventory();
	public Map<Integer,Inventory> repo;
	
	@Override
	public void store(List<Inventory> t) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
		for(Inventory in5:t)
		       s.save(in5);
		tx.commit();
        s.close();
		
	}

	@Override
	public Inventory get(int id) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
		return s.get(Inventory.class, id);
		
	}

	@Override
	public void delete(Inventory i) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
		s.delete(i);
		tx.commit();
		s.close();
		factory.close();
//		s.save(i);
	     System.out.println("Deleted");
	}

	@Override
	public List<Inventory> getAll() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");// populates the data of the
                                            // configuration file

		// creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("from Inventory");
        java.util.List list = query.list();
        System.out.println(list);
        session.save(list);
        t.commit();
        session.close();
	
		return list;
	}

}
