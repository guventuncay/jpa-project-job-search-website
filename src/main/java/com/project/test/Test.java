package com.project.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.project.model.Address;
import com.project.model.Advertisement;
import com.project.model.Education;
import com.project.model.User;
import com.project.model.UserDetail;
import com.project.model.UserInfo;
import com.project.repository.AdvertisementRepository;
import com.project.repository.EducationRepository;
import com.project.repository.UserDetailRepository;
import com.project.repository.UserRepository;
import com.project.repository.impl.AdvertisementRepositoryImpl;
import com.project.repository.impl.EducationRepositoryImpl;
import com.project.repository.impl.UserDetailRepositoryImpl;
import com.project.repository.impl.UserRepositoryImpl;

public class Test {

	private static AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();
	private static EducationRepository educationRepository = new EducationRepositoryImpl();
	private static UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();
	private static UserRepository userRepository = new UserRepositoryImpl();

	public static void main(String[] args) {

		insertData();

		
		
//		List<User> users = userRepository.findUsers();
//		users.forEach(System.out::println);

//		User user = userRepository.findByUsernameWithUserDetail("Guvenx");
//		System.out.println(user);

//		UserDetail userDetail = userDetailRepository.findById(1);
//		System.out.println(userDetail);
		
//		Education education = educationRepository.findById(1);
//		System.out.println(education);

//		List<Advertisement> advertisements = advertisementRepository.findByUsername("Guvenx");
//		System.out.println(advertisements);
		
		
	

	}

	public static void insertData() {

		User user1 = new User("Guvenx", "123123", new Date());

		UserDetail userDetail1 = new UserDetail("Guven", "Tuncay",
				new GregorianCalendar(1999, Calendar.DECEMBER, 28).getTime());
		user1.setUserDetail(userDetail1);

		Address address1 = new Address("Pasabayir", "TestRoad", "10200", "Balikesir");
		List<Address> addressList1 = new ArrayList<Address>();
		addressList1.add(address1);
		userDetail1.setAddresses(addressList1);

		Advertisement advertisement1 = new Advertisement("Java Developer", "Java Developer", "CS Degree");

		List<Education> educationList1 = new ArrayList<Education>();
		Education education1 = new Education("BTU");
		educationList1.add(education1);

		advertisement1.setEducations(educationList1);

		List<Advertisement> advertisementList1 = new ArrayList<Advertisement>();
		advertisementList1.add(advertisement1);

		userDetail1.setAdvertisements(advertisementList1);

		userRepository.saveUser(user1);
		//userDetailRepository.saveUserDetail(userDetail1);
		//educationRepository.saveEducation(education1);
		//advertisementRepository.saveAdvertisement(advertisement1);

	}
}
