package com.project.repository;

import java.util.List;

import com.project.entityFactory.EntityFactory;
import com.project.entityFactory.impl.EntityFactoryImpl;
import com.project.model.Education;

public interface EducationRepository {
	
	EntityFactory entityfactory = new EntityFactoryImpl();
	
	boolean saveEducation(Education education);
	
	boolean updateEducation(Education education);
	
	boolean removeEducation(Education education); 
	
	Education findById(Integer id);
	
	List<Education> findEducations();
	
	Education findByIdWithAdvertisements(Integer id);
}
