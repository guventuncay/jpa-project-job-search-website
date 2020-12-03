package com.project.service.impl;

import java.util.List;

import com.project.model.Advertisement;
import com.project.repository.AdvertisementRepository;
import com.project.repository.impl.AdvertisementRepositoryImpl;
import com.project.service.AdvertisementService;

public class AdvertisementServiceImpl implements AdvertisementService {

	private AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();

	@Override
	public boolean saveAdvertisement(Advertisement advertisement) {

		return this.advertisementRepository.saveAdvertisement(advertisement);

	}

	@Override
	public boolean updateAdvertisement(Advertisement advertisement) {
		return this.advertisementRepository.updateAdvertisement(advertisement);
	}

	@Override
	public boolean remove(Advertisement advertisement) {
		return this.advertisementRepository.remove(advertisement);
	}

	@Override
	public Advertisement findById(Integer id) {
		return this.advertisementRepository.findById(id);
	}

	@Override
	public List<Advertisement> findByUsername(String username) {
		return this.advertisementRepository.findByUsername(username);
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		return this.advertisementRepository.findAdvertisements();
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		return this.advertisementRepository.findAdvertisementEntities(firstResult, maxResult);
	}
}
