package org.quetzaco.experts.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Udset  implements Serializable  {
    private Integer id;

    private Integer projectId;

    private Date createdTime;

    private Date updatedTime;

    private String recordFlag;
    
    private Udsetcompany setCompany;
    private Udsetexpert setExpert;
    private Udsetmajor setMajor;
    private Udsetregion setRegion;
    
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

	public Udsetcompany getSetCompany() {
		return setCompany;
	}

	public void setSetCompany(Udsetcompany setCompany) {
		this.setCompany = setCompany;
	}

	public Udsetexpert getSetExpert() {
		return setExpert;
	}

	public void setSetExpert(Udsetexpert setExpert) {
		this.setExpert = setExpert;
	}

	public Udsetmajor getSetMajor() {
		return setMajor;
	}

	public void setSetMajor(Udsetmajor setMajor) {
		this.setMajor = setMajor;
	}

	public Udsetregion getSetRegion() {
		return setRegion;
	}

	public void setSetRegion(Udsetregion setRegion) {
		this.setRegion = setRegion;
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