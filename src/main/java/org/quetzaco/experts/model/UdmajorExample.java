package org.quetzaco.experts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UdmajorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UdmajorExample() {
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

        public Criteria andMajorCodeIsNull() {
            addCriterion("major_code is null");
            return (Criteria) this;
        }

        public Criteria andMajorCodeIsNotNull() {
            addCriterion("major_code is not null");
            return (Criteria) this;
        }

        public Criteria andMajorCodeEqualTo(String value) {
            addCriterion("major_code =", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotEqualTo(String value) {
            addCriterion("major_code <>", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeGreaterThan(String value) {
            addCriterion("major_code >", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("major_code >=", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLessThan(String value) {
            addCriterion("major_code <", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLessThanOrEqualTo(String value) {
            addCriterion("major_code <=", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeLike(String value) {
            addCriterion("major_code like", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotLike(String value) {
            addCriterion("major_code not like", value, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeIn(List<String> values) {
            addCriterion("major_code in", values, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotIn(List<String> values) {
            addCriterion("major_code not in", values, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeBetween(String value1, String value2) {
            addCriterion("major_code between", value1, value2, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorCodeNotBetween(String value1, String value2) {
            addCriterion("major_code not between", value1, value2, "majorCode");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNull() {
            addCriterion("major_name is null");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNotNull() {
            addCriterion("major_name is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNameEqualTo(String value) {
            addCriterion("major_name =", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotEqualTo(String value) {
            addCriterion("major_name <>", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThan(String value) {
            addCriterion("major_name >", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThanOrEqualTo(String value) {
            addCriterion("major_name >=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThan(String value) {
            addCriterion("major_name <", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThanOrEqualTo(String value) {
            addCriterion("major_name <=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLike(String value) {
            addCriterion("major_name like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotLike(String value) {
            addCriterion("major_name not like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameIn(List<String> values) {
            addCriterion("major_name in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotIn(List<String> values) {
            addCriterion("major_name not in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameBetween(String value1, String value2) {
            addCriterion("major_name between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotBetween(String value1, String value2) {
            addCriterion("major_name not between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorDescIsNull() {
            addCriterion("major_desc is null");
            return (Criteria) this;
        }

        public Criteria andMajorDescIsNotNull() {
            addCriterion("major_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMajorDescEqualTo(String value) {
            addCriterion("major_desc =", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescNotEqualTo(String value) {
            addCriterion("major_desc <>", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescGreaterThan(String value) {
            addCriterion("major_desc >", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescGreaterThanOrEqualTo(String value) {
            addCriterion("major_desc >=", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescLessThan(String value) {
            addCriterion("major_desc <", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescLessThanOrEqualTo(String value) {
            addCriterion("major_desc <=", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescLike(String value) {
            addCriterion("major_desc like", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescNotLike(String value) {
            addCriterion("major_desc not like", value, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescIn(List<String> values) {
            addCriterion("major_desc in", values, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescNotIn(List<String> values) {
            addCriterion("major_desc not in", values, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescBetween(String value1, String value2) {
            addCriterion("major_desc between", value1, value2, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andMajorDescNotBetween(String value1, String value2) {
            addCriterion("major_desc not between", value1, value2, "majorDesc");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("created_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("created_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("created_dt =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("created_dt <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("created_dt >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_dt >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("created_dt <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("created_dt <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("created_dt in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("created_dt not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("created_dt between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("created_dt not between", value1, value2, "createdDt");
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