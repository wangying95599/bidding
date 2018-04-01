package org.quetzaco.experts.model;

import java.io.Serializable;
import java.util.Date;

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