package com.project.service;

import java.util.List;

import com.project.model.User;
import com.project.model.UserInfo;

public interface UserService {
	boolean saveUser(User user);

	boolean updateUser(User user);

	boolean removeUser(User user);

	User findById(Integer Id);

	User findByUsername(String username);

	User findByUsernameWithUserDetail(String username);

	List<User> findUsers();

	List<User> findUsersEntities(int firstResult, int maxResult);

	int findUserCount();

	UserInfo findUserInfoByUsername(String username);
}
