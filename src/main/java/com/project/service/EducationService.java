package com.project.service;

import java.util.List;

import com.project.model.Education;

public interface EducationService {
	
	boolean saveEducation(Education education);

	boolean updateEducation(Education education);

	boolean removeEducation(Education education);

	Education findById(Integer id);

	List<Education> findEducations();

	Education findByIdWithAdvertisements(Integer id);
}
