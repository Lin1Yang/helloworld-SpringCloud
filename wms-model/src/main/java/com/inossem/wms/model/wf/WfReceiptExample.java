package com.inossem.wms.model.wf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfReceiptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WfReceiptExample() {
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

        public Criteria andReceiptTypeIsNull() {
            addCriterion("receipt_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeIsNotNull() {
            addCriterion("receipt_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeEqualTo(Integer value) {
            addCriterion("receipt_type =", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeNotEqualTo(Integer value) {
            addCriterion("receipt_type <>", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeGreaterThan(Integer value) {
            addCriterion("receipt_type >", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("receipt_type >=", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeLessThan(Integer value) {
            addCriterion("receipt_type <", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("receipt_type <=", value, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeIn(List<Integer> values) {
            addCriterion("receipt_type in", values, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeNotIn(List<Integer> values) {
            addCriterion("receipt_type not in", values, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeBetween(Integer value1, Integer value2) {
            addCriterion("receipt_type between", value1, value2, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("receipt_type not between", value1, value2, "receiptType");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeIsNull() {
            addCriterion("receipt_code is null");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeIsNotNull() {
            addCriterion("receipt_code is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeEqualTo(String value) {
            addCriterion("receipt_code =", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeNotEqualTo(String value) {
            addCriterion("receipt_code <>", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeGreaterThan(String value) {
            addCriterion("receipt_code >", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_code >=", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeLessThan(String value) {
            addCriterion("receipt_code <", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeLessThanOrEqualTo(String value) {
            addCriterion("receipt_code <=", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeLike(String value) {
            addCriterion("receipt_code like", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeNotLike(String value) {
            addCriterion("receipt_code not like", value, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeIn(List<String> values) {
            addCriterion("receipt_code in", values, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeNotIn(List<String> values) {
            addCriterion("receipt_code not in", values, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeBetween(String value1, String value2) {
            addCriterion("receipt_code between", value1, value2, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andReceiptCodeNotBetween(String value1, String value2) {
            addCriterion("receipt_code not between", value1, value2, "receiptCode");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNull() {
            addCriterion("pi_id is null");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNotNull() {
            addCriterion("pi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiIdEqualTo(String value) {
            addCriterion("pi_id =", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotEqualTo(String value) {
            addCriterion("pi_id <>", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThan(String value) {
            addCriterion("pi_id >", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThanOrEqualTo(String value) {
            addCriterion("pi_id >=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThan(String value) {
            addCriterion("pi_id <", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThanOrEqualTo(String value) {
            addCriterion("pi_id <=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLike(String value) {
            addCriterion("pi_id like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotLike(String value) {
            addCriterion("pi_id not like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdIn(List<String> values) {
            addCriterion("pi_id in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotIn(List<String> values) {
            addCriterion("pi_id not in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdBetween(String value1, String value2) {
            addCriterion("pi_id between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotBetween(String value1, String value2) {
            addCriterion("pi_id not between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdIsNull() {
            addCriterion("receipt_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdIsNotNull() {
            addCriterion("receipt_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdEqualTo(String value) {
            addCriterion("receipt_user_id =", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdNotEqualTo(String value) {
            addCriterion("receipt_user_id <>", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdGreaterThan(String value) {
            addCriterion("receipt_user_id >", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_user_id >=", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdLessThan(String value) {
            addCriterion("receipt_user_id <", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdLessThanOrEqualTo(String value) {
            addCriterion("receipt_user_id <=", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdLike(String value) {
            addCriterion("receipt_user_id like", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdNotLike(String value) {
            addCriterion("receipt_user_id not like", value, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdIn(List<String> values) {
            addCriterion("receipt_user_id in", values, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdNotIn(List<String> values) {
            addCriterion("receipt_user_id not in", values, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdBetween(String value1, String value2) {
            addCriterion("receipt_user_id between", value1, value2, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andReceiptUserIdNotBetween(String value1, String value2) {
            addCriterion("receipt_user_id not between", value1, value2, "receiptUserId");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(Byte value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(Byte value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(Byte value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(Byte value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(Byte value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<Byte> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<Byte> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(Byte value1, Byte value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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