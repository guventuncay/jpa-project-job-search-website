package com.project.repository;

import java.util.List;

import com.project.entityFactory.EntityFactory;
import com.project.entityFactory.impl.EntityFactoryImpl;
import com.project.model.UserDetail;

public interface UserDetailRepository {
	
	EntityFactory entityfactory = new EntityFactoryImpl();

	boolean saveUserDetail(UserDetail userDetail);
	
	boolean updateUserDetail(UserDetail userDetail);
	
	boolean removeUserDetail(UserDetail userDetail);
	
	UserDetail findById(Integer Id);
	
	UserDetail findByUsername(String username);
	
	UserDetail findByUsernameWithAddress(String username);
	
	UserDetail findByUsernameWithAdvertisement(String username);
}
