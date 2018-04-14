package org.quetzaco.experts.model;

import java.util.Date;

public class Udsetresult {
	private Integer projectId;

	private Integer expertId;

	private Date createdDt;

	private String randomCode;

	private String noticeStatus;

	private String confirmStatus;
	
	
	private String purchaseProject;
	

	public String getPurchaseProject() {
		return purchaseProject;
	}

	public void setPurchaseProject(String purchaseProject) {
		this.purchaseProject = purchaseProject;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getExpertId() {
		return expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode == null ? null : randomCode.trim();
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus == null ? null : noticeStatus.trim();
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
	}

	private String majorCode;
	private String majorName;

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}



	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	private String name;

	private String phone;

	private String company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}