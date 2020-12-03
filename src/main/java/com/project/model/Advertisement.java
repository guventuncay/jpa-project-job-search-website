package com.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Advertisement.findById", query = "select a from Advertisement a "
				+ "left join fetch a.educations where a.advertisementId = :advertisementId"),
		@NamedQuery(name = "Advertisement.findByUsername1", query = "select a from User u "
				+ "left join u.userDetail ud " + "left join ud.advertisements a " + "where u.username = :username"),
		@NamedQuery(name = "Advertisement.findByUsername2", query = "select a from Advertisement a "
				+ "where a.userDetail.user.username = :username"),
		@NamedQuery(name = "Advertisement.findAdvertisements", query = "select a from Advertisement a")

})
public class Advertisement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advertisementId;

	private String title;

	@Lob
	private String workDefination;

	@Lob
	private String criteria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private boolean enabled = false;

	@Temporal(TemporalType.TIMESTAMP)
	private Date removeDate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "advertisement_education", joinColumns = @JoinColumn(name = "advertisementId"), inverseJoinColumns = @JoinColumn(name = "educationId"))
	private List<Education> educations = new ArrayList<Education>();

	@ManyToOne
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;

	public Advertisement() {
	}

	public Advertisement(String title, String workDefination, String criteria) {
		this.title = title;
		this.workDefination = workDefination;
		this.criteria = criteria;
	}

	public Integer getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkDefination() {
		return workDefination;
	}

	public void setWorkDefination(String workDefination) {
		this.workDefination = workDefination;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", title=" + title + ", workDefination="
				+ workDefination + ", criteria=" + criteria + ", addDate=" + addDate + ", updateDate=" + updateDate
				+ ", enabled=" + enabled + ", removeDate=" + removeDate + "]";
	}

}
