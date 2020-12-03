package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.project.model.User;
import com.project.model.UserInfo;
import com.project.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	private EntityManager entityManager = entityfactory.getEntityManager();

	private EntityTransaction transaction = this.entityManager.getTransaction();

	@Override
	public boolean saveUser(User user) {
		try {
			this.transaction.begin();

			this.entityManager.persist(user);

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
	public boolean updateUser(User user) {

		try {
			this.transaction.begin();

			this.entityManager.merge(user);
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
	public boolean removeUser(User user) {
		try {
			if (this.entityManager.contains(user)) {

				this.entityManager.remove(user);

			} else {

				User deleteUser = this.findById(user.getUserId());

				this.entityManager.remove(deleteUser);

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
	public User findById(Integer Id) {
		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);
			typedQuery.setParameter("userId", Id);

			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.err.println(e);
		}

		return user;
	}

	@Override
	public User findByUsername(String username) {
		User users = null;

		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsername", User.class);
			typedQuery.setParameter("username", username);

			users = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return users;
	}

	@Override
	public User findByUsernameWithUserDetail(String username) {
		User users = null;

		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUsernameWithUserDetail",
					User.class);
			typedQuery.setParameter("username", username);

			users = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return users;
	}

	@Override
	public List<User> findUsers() {
		List<User> users = null;

		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);

			users = typedQuery.getResultList();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return users;
	}

	@Override
	public List<User> findUsersEntities(int firstResult, int maxResult) {
		List<User> users = null;

		try {
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findUsers", User.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			users = typedQuery.getResultList();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return users;
	}

	@Override
	public int findUserCount() {

		int count = 0;

		try {
			TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("User.count", Integer.class);

			count = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			System.err.println(e);
		}

		return count;
	}

	@Override
	public UserInfo findUserInfoByUsername(String username) {

		UserInfo userInfo = null;

		try {
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("findUserInfoByUsername",
					UserInfo.class);
			typedQuery.setParameter("username", username);

		} catch (NoResultException e) {
			System.err.println(e);
		}
		return userInfo;
	}
}
