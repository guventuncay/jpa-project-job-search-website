package com.project.service;

import com.project.model.UserDetail;

public interface UserDetailService {
	
	boolean saveUserDetail(UserDetail userDetail);

	boolean updateUserDetail(UserDetail userDetail);

	boolean removeUserDetail(UserDetail userDetail);

	UserDetail findById(Integer Id);

	UserDetail findByUsername(String username);

	UserDetail findByUsernameWithAddress(String username);

	UserDetail findByUsernameWithAdvertisement(String username);
}
