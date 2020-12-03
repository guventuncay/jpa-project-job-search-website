package com.project.repository;

import java.util.List;

import com.project.entityFactory.EntityFactory;
import com.project.entityFactory.impl.EntityFactoryImpl;
import com.project.model.Advertisement;

public interface AdvertisementRepository {

	EntityFactory entityfactory = new EntityFactoryImpl();
	
	boolean saveAdvertisement(Advertisement advertisement);
	
	boolean updateAdvertisement(Advertisement advertisement);
	
	boolean remove(Advertisement advertisement);

	Advertisement findById(Integer id);
	
	List<Advertisement> findByUsername(String username);
	
	List<Advertisement> findAdvertisements();
	
	List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult);


}
