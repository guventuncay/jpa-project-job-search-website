package com.project.entityFactory.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.project.entityFactory.EntityFactory;

public class EntityFactoryImpl implements EntityFactory{

	private EntityManager entityManager = null;

	@Override
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		this.entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
}
