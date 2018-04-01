package org.quetzaco.experts.model;

import java.util.Date;

public class Udmajor {
    private Integer id;

    private String majorCode;

    private String majorName;

    private String majorDesc;

    private Date createdDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getMajorDesc() {
        return majorDesc;
    }

    public void setMajorDesc(String majorDesc) {
        this.majorDesc = majorDesc == null ? null : majorDesc.trim();
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }
}