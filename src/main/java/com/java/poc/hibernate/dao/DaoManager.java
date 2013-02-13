package com.java.poc.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class DaoManager
 *//*
@Stateless*/
public class DaoManager<T> implements DaoManagerLocal<T> {

    /**
     * Default constructor.
     */
    public DaoManager() {

    }

    @PersistenceContext
    private EntityManager entityManager;

	public void add(Object entity) {

		entityManager.persist(entity);

	}

	public void remove(Object entity) {

		entityManager.refresh(entity);

	}

	public EntityTransaction getTransaction() {

		return entityManager.getTransaction();

	}

	public Query createQuery(String qlString) {

		return entityManager.createQuery(qlString);

	}

	public void clear() {

		entityManager.clear();

	}

	public boolean contains(Object entity) {

		return entityManager.contains(entity);

	}

	public void refresh(Object entity) {

		entityManager.refresh(entity);

	}

	public T merge(T entity) {

		return entityManager.merge(entity);

	}

	public T find(Class<T> entityClass, Object primaryKey) {

		return entityManager.find(entityClass, primaryKey);

	}

	public Query createNamedQuery(String name) {

		return entityManager.createNamedQuery(name);

	}

}
