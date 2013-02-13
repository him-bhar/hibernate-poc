package com.java.poc.hibernate;

import org.hibernate.Session;

import com.java.poc.hibernate.model.Stock;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {

    public static void main( String[] args ) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Stock stock = new Stock();

        stock.setStockCode("4715");
        stock.setStockName("GENM");

        session.save(stock);
        session.getTransaction().commit();
    }
}
