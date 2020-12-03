package com.project.repository;

import java.util.List;

import com.project.entityFactory.EntityFactory;
import com.project.entityFactory.impl.EntityFactoryImpl;
import com.project.model.User;
import com.project.model.UserInfo;

public interface UserRepository {
	
	EntityFactory entityfactory = new EntityFactoryImpl();
	
	boolean saveUser(User user);
	
	boolean updateUser(User user);
	
	boolean removeUser(User user);

	User findById(Integer Id);
	
	User findByUsername (String username);
	
	User findByUsernameWithUserDetail(String username);
	
	List<User> findUsers();

	List<User> findUsersEntities(int firstResult, int maxResult);
	
	int findUserCount();
	
	UserInfo findUserInfoByUsername(String username);
}
