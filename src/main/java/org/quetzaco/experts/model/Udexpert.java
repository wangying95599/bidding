package org.quetzaco.experts.model;

public class Udexpert {
    private Integer expertId;

    private String no;

    private String card;

    private String name;

    private String phone;

    private String company;

    private String region;

    private String recordFlag;

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag == null ? null : recordFlag.trim();
    }
    
    
    public int score;
    
    
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
    public boolean equals(Object obj) {
    	if(expertId == null)
    		return super.equals(obj);
    	else
    		return expertId.equals(((Udexpert)obj).getExpertId());
    }
	
	@Override
	public String toString() {
		
		return "Expert@id:"+expertId+", score:"+score;
	}
}