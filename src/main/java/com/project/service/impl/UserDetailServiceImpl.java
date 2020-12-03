package com.project.service.impl;

import com.project.model.UserDetail;
import com.project.repository.UserDetailRepository;
import com.project.repository.impl.UserDetailRepositoryImpl;
import com.project.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService{

	private UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

	@Override
	public boolean saveUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.saveUserDetail(userDetail);
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.updateUserDetail(userDetail);
	}

	@Override
	public boolean removeUserDetail(UserDetail userDetail) {
		return this.userDetailRepository.removeUserDetail(userDetail);
	}

	@Override
	public UserDetail findById(Integer Id) {
		return this.userDetailRepository.findById(Id);
	}

	@Override
	public UserDetail findByUsername(String username) {
		return this.userDetailRepository.findByUsername(username);
	}

	@Override
	public UserDetail findByUsernameWithAddress(String username) {
		return this.userDetailRepository.findByUsernameWithAddress(username);
	}

	@Override
	public UserDetail findByUsernameWithAdvertisement(String username) {
		return this.userDetailRepository.findByUsernameWithAdvertisement(username);
	}
	
	
}
