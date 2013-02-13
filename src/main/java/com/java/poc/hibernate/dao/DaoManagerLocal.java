package com.java.poc.hibernate.dao;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/*@Local*/
public interface DaoManagerLocal<T> {

	void add(Object entity);
	void remove(Object entity);
	EntityTransaction getTransaction();
	Query createQuery(String qlString);
	T find(Class<T> entityClass, Object primaryKey);
	void clear();
	boolean contains(Object entity);
	void refresh(Object entity);
	T merge(T entity);
	Query createNamedQuery(String name);

}
