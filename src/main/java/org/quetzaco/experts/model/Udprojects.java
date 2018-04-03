package org.quetzaco.experts.model;

import java.util.Date;

public class Udprojects {
    private Integer id;

    private String purchaseCode;

    private String purchaseProject;

    private String purchaseCompany;

    private String proxyOrg;

    private String extractCompany;

    private Date biddingTime;

    private String biddingLocation;

    private String biddingPeriod;

    private String purchaseType;

    private String smsInfo;

    private String recordFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode == null ? null : purchaseCode.trim();
    }

    public String getPurchaseProject() {
        return purchaseProject;
    }

    public void setPurchaseProject(String purchaseProject) {
        this.purchaseProject = purchaseProject == null ? null : purchaseProject.trim();
    }

    public String getPurchaseCompany() {
        return purchaseCompany;
    }

    public void setPurchaseCompany(String purchaseCompany) {
        this.purchaseCompany = purchaseCompany == null ? null : purchaseCompany.trim();
    }

    public String getProxyOrg() {
        return proxyOrg;
    }

    public void setProxyOrg(String proxyOrg) {
        this.proxyOrg = proxyOrg == null ? null : proxyOrg.trim();
    }

    public String getExtractCompany() {
        return extractCompany;
    }

    public void setExtractCompany(String extractCompany) {
        this.extractCompany = extractCompany == null ? null : extractCompany.trim();
    }

    public Date getBiddingTime() {
        return biddingTime;
    }

    public void setBiddingTime(Date biddingTime) {
        this.biddingTime = biddingTime;
    }

    public String getBiddingLocation() {
        return biddingLocation;
    }

    public void setBiddingLocation(String biddingLocation) {
        this.biddingLocation = biddingLocation == null ? null : biddingLocation.trim();
    }

    public String getBiddingPeriod() {
        return biddingPeriod;
    }

    public void setBiddingPeriod(String biddingPeriod) {
        this.biddingPeriod = biddingPeriod == null ? null : biddingPeriod.trim();
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType == null ? null : purchaseType.trim();
    }

    public String getSmsInfo() {
        return smsInfo;
    }

    public void setSmsInfo(String smsInfo) {
        this.smsInfo = smsInfo == null ? null : smsInfo.trim();
    }

    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag == null ? null : recordFlag.trim();
    }
}