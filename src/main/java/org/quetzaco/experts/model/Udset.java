package org.quetzaco.experts.model;

import java.util.Date;
import java.util.List;

public class Udset {
    private Integer id;

    private Integer projectId;

    private Date createdTime;

    private Date updatedTime;

    private String recordFlag;
    
    private List<Udsetcompany> companyList;
    private List<Udsetexpert> expertList;
    private List<Udsetmajor> majorList;
    private List<Udsetregion> regionList;

    public List<Udsetcompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Udsetcompany> companyList) {
		this.companyList = companyList;
	}

	public List<Udsetexpert> getExpertList() {
		return expertList;
	}

	public void setExpertList(List<Udsetexpert> expertList) {
		this.expertList = expertList;
	}

	public List<Udsetmajor> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Udsetmajor> majorList) {
		this.majorList = majorList;
	}

	public List<Udsetregion> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Udsetregion> regionList) {
		this.regionList = regionList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag == null ? null : recordFlag.trim();
    }
}