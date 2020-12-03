package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.project.model.Advertisement;
import com.project.repository.AdvertisementRepository;

public class AdvertisementRepositoryImpl implements AdvertisementRepository {

	private EntityManager entityManager = entityfactory.getEntityManager();

	private EntityTransaction transaction = this.entityManager.getTransaction();

	@Override
	public boolean saveAdvertisement(final Advertisement advertisement) {

		try {
			this.transaction.begin();

			this.entityManager.persist(advertisement);

			this.transaction.commit();
		} catch (RuntimeException e) {
			System.err.println(e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println(e2);
			}

			return false;
		}

		return true;
	}

	@Override
	public boolean updateAdvertisement(final Advertisement advertisement) {

		try {
			this.transaction.begin();

			this.entityManager.merge(advertisement);
			this.entityManager.flush();
			
			this.transaction.commit();
		} catch (RuntimeException e) {
			System.err.println(e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println(e2);
			}

			return false;
		}

		return true;
	}

	@Override
	public boolean remove(final Advertisement advertisement) {
		try {
			if (this.entityManager.contains(advertisement)) {

				this.entityManager.remove(advertisement);

			} else {

				Advertisement deleteAdvertisement = this.findById(advertisement.getAdvertisementId());

				this.entityManager.remove(deleteAdvertisement);

			}
		} catch (RuntimeException e) {
			System.err.println(e);
			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.err.println(e2);
			}
			
			return false;
		}

		return true;
	}

	@Override
	public Advertisement findById(final Integer Id) {

		Advertisement advertisement = null;
		
		try {
			
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findById", Advertisement.class);
			typedQuery.setParameter("advertisementId", Id);
			
			advertisement = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.err.println(e);
		}
		
		return advertisement;
	}

	@Override
	public List<Advertisement> findByUsername(final String username) {

		List<Advertisement> advertisements = null;
		
		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findByUsername1", Advertisement.class);
			typedQuery.setParameter("username", username);
			
			advertisements = typedQuery.getResultList();
		} catch (NoResultException e) {
			System.err.println(e);
		}
		
		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisements() {

		List<Advertisement> advertisements = null;

		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			
			advertisements = typedQuery.getResultList();
		} catch (NoResultException e) {
			System.err.println(e);
		}
		
		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {

		List<Advertisement> advertisements = null;

		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			
			advertisements = typedQuery.getResultList();
		} catch (NoResultException e) {
			System.err.println(e);
		}
		
		return advertisements;
	}

}
