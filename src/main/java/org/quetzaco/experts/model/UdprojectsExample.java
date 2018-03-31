package org.quetzaco.experts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UdprojectsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UdprojectsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeIsNull() {
            addCriterion("purchase_code is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeIsNotNull() {
            addCriterion("purchase_code is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeEqualTo(String value) {
            addCriterion("purchase_code =", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeNotEqualTo(String value) {
            addCriterion("purchase_code <>", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeGreaterThan(String value) {
            addCriterion("purchase_code >", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_code >=", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeLessThan(String value) {
            addCriterion("purchase_code <", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeLessThanOrEqualTo(String value) {
            addCriterion("purchase_code <=", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeLike(String value) {
            addCriterion("purchase_code like", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeNotLike(String value) {
            addCriterion("purchase_code not like", value, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeIn(List<String> values) {
            addCriterion("purchase_code in", values, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeNotIn(List<String> values) {
            addCriterion("purchase_code not in", values, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeBetween(String value1, String value2) {
            addCriterion("purchase_code between", value1, value2, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseCodeNotBetween(String value1, String value2) {
            addCriterion("purchase_code not between", value1, value2, "purchaseCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIsNull() {
            addCriterion("purchase_project is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIsNotNull() {
            addCriterion("purchase_project is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectEqualTo(String value) {
            addCriterion("purchase_project =", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNotEqualTo(String value) {
            addCriterion("purchase_project <>", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectGreaterThan(String value) {
            addCriterion("purchase_project >", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_project >=", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectLessThan(String value) {
            addCriterion("purchase_project <", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectLessThanOrEqualTo(String value) {
            addCriterion("purchase_project <=", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectLike(String value) {
            addCriterion("purchase_project like", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNotLike(String value) {
            addCriterion("purchase_project not like", value, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectIn(List<String> values) {
            addCriterion("purchase_project in", values, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNotIn(List<String> values) {
            addCriterion("purchase_project not in", values, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectBetween(String value1, String value2) {
            addCriterion("purchase_project between", value1, value2, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseProjectNotBetween(String value1, String value2) {
            addCriterion("purchase_project not between", value1, value2, "purchaseProject");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyIsNull() {
            addCriterion("purchase_company is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyIsNotNull() {
            addCriterion("purchase_company is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyEqualTo(String value) {
            addCriterion("purchase_company =", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyNotEqualTo(String value) {
            addCriterion("purchase_company <>", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyGreaterThan(String value) {
            addCriterion("purchase_company >", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_company >=", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyLessThan(String value) {
            addCriterion("purchase_company <", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyLessThanOrEqualTo(String value) {
            addCriterion("purchase_company <=", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyLike(String value) {
            addCriterion("purchase_company like", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyNotLike(String value) {
            addCriterion("purchase_company not like", value, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyIn(List<String> values) {
            addCriterion("purchase_company in", values, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyNotIn(List<String> values) {
            addCriterion("purchase_company not in", values, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyBetween(String value1, String value2) {
            addCriterion("purchase_company between", value1, value2, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andPurchaseCompanyNotBetween(String value1, String value2) {
            addCriterion("purchase_company not between", value1, value2, "purchaseCompany");
            return (Criteria) this;
        }

        public Criteria andProxyOrgIsNull() {
            addCriterion("proxy_org is null");
            return (Criteria) this;
        }

        public Criteria andProxyOrgIsNotNull() {
            addCriterion("proxy_org is not null");
            return (Criteria) this;
        }

        public Criteria andProxyOrgEqualTo(String value) {
            addCriterion("proxy_org =", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgNotEqualTo(String value) {
            addCriterion("proxy_org <>", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgGreaterThan(String value) {
            addCriterion("proxy_org >", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_org >=", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgLessThan(String value) {
            addCriterion("proxy_org <", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgLessThanOrEqualTo(String value) {
            addCriterion("proxy_org <=", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgLike(String value) {
            addCriterion("proxy_org like", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgNotLike(String value) {
            addCriterion("proxy_org not like", value, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgIn(List<String> values) {
            addCriterion("proxy_org in", values, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgNotIn(List<String> values) {
            addCriterion("proxy_org not in", values, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgBetween(String value1, String value2) {
            addCriterion("proxy_org between", value1, value2, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andProxyOrgNotBetween(String value1, String value2) {
            addCriterion("proxy_org not between", value1, value2, "proxyOrg");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyIsNull() {
            addCriterion("extract_company is null");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyIsNotNull() {
            addCriterion("extract_company is not null");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyEqualTo(String value) {
            addCriterion("extract_company =", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyNotEqualTo(String value) {
            addCriterion("extract_company <>", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyGreaterThan(String value) {
            addCriterion("extract_company >", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("extract_company >=", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyLessThan(String value) {
            addCriterion("extract_company <", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyLessThanOrEqualTo(String value) {
            addCriterion("extract_company <=", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyLike(String value) {
            addCriterion("extract_company like", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyNotLike(String value) {
            addCriterion("extract_company not like", value, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyIn(List<String> values) {
            addCriterion("extract_company in", values, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyNotIn(List<String> values) {
            addCriterion("extract_company not in", values, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyBetween(String value1, String value2) {
            addCriterion("extract_company between", value1, value2, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andExtractCompanyNotBetween(String value1, String value2) {
            addCriterion("extract_company not between", value1, value2, "extractCompany");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeIsNull() {
            addCriterion("bidding_time is null");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeIsNotNull() {
            addCriterion("bidding_time is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeEqualTo(Date value) {
            addCriterion("bidding_time =", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeNotEqualTo(Date value) {
            addCriterion("bidding_time <>", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeGreaterThan(Date value) {
            addCriterion("bidding_time >", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bidding_time >=", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeLessThan(Date value) {
            addCriterion("bidding_time <", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeLessThanOrEqualTo(Date value) {
            addCriterion("bidding_time <=", value, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeIn(List<Date> values) {
            addCriterion("bidding_time in", values, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeNotIn(List<Date> values) {
            addCriterion("bidding_time not in", values, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeBetween(Date value1, Date value2) {
            addCriterion("bidding_time between", value1, value2, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingTimeNotBetween(Date value1, Date value2) {
            addCriterion("bidding_time not between", value1, value2, "biddingTime");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationIsNull() {
            addCriterion("bidding_location is null");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationIsNotNull() {
            addCriterion("bidding_location is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationEqualTo(String value) {
            addCriterion("bidding_location =", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationNotEqualTo(String value) {
            addCriterion("bidding_location <>", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationGreaterThan(String value) {
            addCriterion("bidding_location >", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_location >=", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationLessThan(String value) {
            addCriterion("bidding_location <", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationLessThanOrEqualTo(String value) {
            addCriterion("bidding_location <=", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationLike(String value) {
            addCriterion("bidding_location like", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationNotLike(String value) {
            addCriterion("bidding_location not like", value, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationIn(List<String> values) {
            addCriterion("bidding_location in", values, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationNotIn(List<String> values) {
            addCriterion("bidding_location not in", values, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationBetween(String value1, String value2) {
            addCriterion("bidding_location between", value1, value2, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingLocationNotBetween(String value1, String value2) {
            addCriterion("bidding_location not between", value1, value2, "biddingLocation");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodIsNull() {
            addCriterion("bidding_period is null");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodIsNotNull() {
            addCriterion("bidding_period is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodEqualTo(String value) {
            addCriterion("bidding_period =", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodNotEqualTo(String value) {
            addCriterion("bidding_period <>", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodGreaterThan(String value) {
            addCriterion("bidding_period >", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("bidding_period >=", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodLessThan(String value) {
            addCriterion("bidding_period <", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodLessThanOrEqualTo(String value) {
            addCriterion("bidding_period <=", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodLike(String value) {
            addCriterion("bidding_period like", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodNotLike(String value) {
            addCriterion("bidding_period not like", value, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodIn(List<String> values) {
            addCriterion("bidding_period in", values, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodNotIn(List<String> values) {
            addCriterion("bidding_period not in", values, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodBetween(String value1, String value2) {
            addCriterion("bidding_period between", value1, value2, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andBiddingPeriodNotBetween(String value1, String value2) {
            addCriterion("bidding_period not between", value1, value2, "biddingPeriod");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNull() {
            addCriterion("purchase_type is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNotNull() {
            addCriterion("purchase_type is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeEqualTo(String value) {
            addCriterion("purchase_type =", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotEqualTo(String value) {
            addCriterion("purchase_type <>", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThan(String value) {
            addCriterion("purchase_type >", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_type >=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThan(String value) {
            addCriterion("purchase_type <", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThanOrEqualTo(String value) {
            addCriterion("purchase_type <=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLike(String value) {
            addCriterion("purchase_type like", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotLike(String value) {
            addCriterion("purchase_type not like", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIn(List<String> values) {
            addCriterion("purchase_type in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotIn(List<String> values) {
            addCriterion("purchase_type not in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeBetween(String value1, String value2) {
            addCriterion("purchase_type between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotBetween(String value1, String value2) {
            addCriterion("purchase_type not between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andSmsInfoIsNull() {
            addCriterion("sms_info is null");
            return (Criteria) this;
        }

        public Criteria andSmsInfoIsNotNull() {
            addCriterion("sms_info is not null");
            return (Criteria) this;
        }

        public Criteria andSmsInfoEqualTo(String value) {
            addCriterion("sms_info =", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoNotEqualTo(String value) {
            addCriterion("sms_info <>", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoGreaterThan(String value) {
            addCriterion("sms_info >", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("sms_info >=", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoLessThan(String value) {
            addCriterion("sms_info <", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoLessThanOrEqualTo(String value) {
            addCriterion("sms_info <=", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoLike(String value) {
            addCriterion("sms_info like", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoNotLike(String value) {
            addCriterion("sms_info not like", value, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoIn(List<String> values) {
            addCriterion("sms_info in", values, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoNotIn(List<String> values) {
            addCriterion("sms_info not in", values, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoBetween(String value1, String value2) {
            addCriterion("sms_info between", value1, value2, "smsInfo");
            return (Criteria) this;
        }

        public Criteria andSmsInfoNotBetween(String value1, String value2) {
            addCriterion("sms_info not between", value1, value2, "smsInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}