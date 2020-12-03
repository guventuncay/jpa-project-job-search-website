package com.project.service.impl;

import java.util.List;

import com.project.model.Education;
import com.project.repository.EducationRepository;
import com.project.repository.impl.EducationRepositoryImpl;
import com.project.service.EducationService;

public class EducationServiceImpl implements EducationService{

	private EducationRepository educationRepository = new EducationRepositoryImpl();

	@Override
	public boolean saveEducation(Education education) {
		return this.educationRepository.saveEducation(education);
	}

	@Override
	public boolean updateEducation(Education education) {
		return this.educationRepository.updateEducation(education);
	}

	@Override
	public boolean removeEducation(Education education) {

		return this.educationRepository.removeEducation(education);
	}

	@Override
	public Education findById(Integer id) {
		return this.educationRepository.findById(id);
	}

	@Override
	public List<Education> findEducations() {

		return this.educationRepository.findEducations();
	}

	@Override
	public Education findByIdWithAdvertisements(Integer id) {

		return this.educationRepository.findByIdWithAdvertisements(id);
	}
}
