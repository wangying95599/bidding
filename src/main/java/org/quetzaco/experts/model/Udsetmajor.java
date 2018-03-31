package org.quetzaco.experts.model;

import java.util.Date;

public class Udsetmajor {
    private Integer projectId;

    private String majorCode;

    private Long majorNumber;

    private Date createdDt;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    public Long getMajorNumber() {
        return majorNumber;
    }

    public void setMajorNumber(Long majorNumber) {
        this.majorNumber = majorNumber;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }
}