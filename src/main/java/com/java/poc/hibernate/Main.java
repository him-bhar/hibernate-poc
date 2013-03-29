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

    	Main m = new Main();
    	try {
    		//m.saveObject();
			m.updateUsingTwoThreads();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void updateUsingTwoThreads() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Session session = null;
                try {
                    session = HibernateUtil.getSessionFactory().openSession();
                    org.hibernate.Transaction transaction = session
                            .beginTransaction();
                    Stock airline = (Stock) session.get(Stock.class,
                            new Integer(1));
                    System.out.println("getVersion in "+airline.getVersion()+"in "+ Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    airline.setStockName("asdasd2234phl1e");
                    session.saveOrUpdate(airline);
                    System.out.println("getVersion in "+airline.getVersion()+"in "+ Thread.currentThread().getName());
                    transaction.commit();
                }catch(Throwable t){
                    System.out.println(t);

                }finally {
                    session.close();
                }
            }
        },"earlier");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                Session session = null;
                try {
                    session = HibernateUtil.getSessionFactory().openSession();
                    //session.clear();
                    org.hibernate.Transaction transaction = session.beginTransaction();
                    Stock airline = (Stock) session.get(Stock.class,new Integer(1));
                    System.out.println("getVersion in "+airline.getVersion()+"in "+ Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("getVersion in "+airline.getVersion()+"in "+ Thread.currentThread().getName());
                    airline.setStockName("asdasdba12admain");
                    session.saveOrUpdate(airline);
                    transaction.commit();
                }catch(Throwable t){
                    System.out.println(t);

                } finally {
                    session.close();
                }
            }
        },"later");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    public void saveObject() {
    	 Session session = HibernateUtil.getSessionFactory().openSession();

         session.beginTransaction();
         Stock stock = new Stock();

         stock.setStockCode("4715");
         stock.setStockName("GENM");

         session.save(stock);
         session.getTransaction().commit();
         session.close();
    }
}
