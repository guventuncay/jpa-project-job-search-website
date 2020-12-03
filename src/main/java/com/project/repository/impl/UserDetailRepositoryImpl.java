package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.project.model.UserDetail;
import com.project.repository.UserDetailRepository;

public class UserDetailRepositoryImpl implements UserDetailRepository {

	private EntityManager entityManager = entityfactory.getEntityManager();

	private EntityTransaction transaction = this.entityManager.getTransaction();

	@Override
	public boolean saveUserDetail(UserDetail userDetail) {

		try {
			this.transaction.begin();

			this.entityManager.persist(userDetail);

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
	public boolean updateUserDetail(UserDetail userDetail) {
		try {
			this.transaction.begin();

			this.entityManager.merge(userDetail);
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
	public boolean removeUserDetail(UserDetail userDetail) {
		try {
			if (this.entityManager.contains(userDetail)) {

				this.entityManager.remove(userDetail);

			} else {

				UserDetail deleteUserDetail = this.findById(userDetail.getUserDetailId());

				this.entityManager.remove(deleteUserDetail);

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
	public UserDetail findById(Integer Id) {
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findById",
					UserDetail.class);
			typedQuery.setParameter("userDetailId", Id);

			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.err.println(e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findByUsername(String username) {
		UserDetail userDetail = null;

		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsername",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findByUsernameWithAddress(String username) {
		UserDetail userDetail = null;

		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsernameWithAddress",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findByUsernameWithAdvertisement(String username) {
		UserDetail userDetail = null;

		try {
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsernameWithAdvertisement",
					UserDetail.class);
			typedQuery.setParameter("username", username);

			userDetail = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return userDetail;
	}

}
