package com.project.service.impl;

import java.util.List;

import com.project.model.User;
import com.project.model.UserInfo;
import com.project.repository.UserRepository;
import com.project.repository.impl.UserRepositoryImpl;
import com.project.service.UserService;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public boolean saveUser(User user) {
		return this.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return this.userRepository.updateUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		return this.userRepository.removeUser(user);
	}

	@Override
	public User findById(Integer Id) {
		return this.userRepository.findById(Id);
	}

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User findByUsernameWithUserDetail(String username) {
		return this.userRepository.findByUsernameWithUserDetail(username);
	}

	@Override
	public List<User> findUsers() {
		return this.userRepository.findUsers();
	}

	@Override
	public List<User> findUsersEntities(int firstResult, int maxResult) {
		return this.userRepository.findUsersEntities(firstResult, maxResult);
	}

	@Override
	public int findUserCount() {
		return this.userRepository.findUserCount();
	}

	@Override
	public UserInfo findUserInfoByUsername(String username) {
		return this.userRepository.findUserInfoByUsername(username);
	}
}
