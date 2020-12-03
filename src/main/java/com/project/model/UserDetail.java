package com.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.project.model.util.PhoneType;

@Entity
@NamedQueries({
		@NamedQuery(name = "UserDetail.findById" , query = "select ud from UserDetail ud where ud.userDetailId = :userDetailId"),
		@NamedQuery(name = "UserDetail.findByUsername", query = "select ud from UserDetail ud "
				+ "where ud.user.username = :username"),
		@NamedQuery(name = "UserDetail.findByUsernameWithAddress", query = "select ud from UserDetail ud "
				+ "left join fetch ud.addresses where ud.user.username = :username"),
		@NamedQuery(name = "UserDetail.findByUsernameWithAdvertisement", query = "select ud from UserDetail ud "
				+ "left join fetch ud.advertisements where ud.user.username = :username")
})
public class UserDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userDetailId;

	private String firstName;

	private String lastName;

	private Date birthOfDate;

	@ElementCollection
	@JoinTable(name = "userDetail_phoneNumber", joinColumns = @JoinColumn(name = "userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_address", joinColumns = @JoinColumn(name = "userDetailId"))
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "userDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private User user;

	public UserDetail() {
	}

	public UserDetail(String firstName, String lastName, Date birthOfDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthOfDate=" + birthOfDate + ", phoneNumbers=" + phoneNumbers + ", addresses=" + addresses
				+ ", advertisements=" + advertisements + "]";
	}
	
	

}
