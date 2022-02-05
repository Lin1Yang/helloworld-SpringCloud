package com.inossem.wms.model.wf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfReceiptUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WfReceiptUserExample() {
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


        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(String value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(String value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(String value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(String value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(String value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(String value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLike(String value) {
            addCriterion("comment_id like", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotLike(String value) {
            addCriterion("comment_id not like", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<String> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<String> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(String value1, String value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(String value1, String value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("approve_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterion("approve_time =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterion("approve_time <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterion("approve_time >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_time >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterion("approve_time <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterion("approve_time <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterion("approve_time in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterion("approve_time not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterion("approve_time between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterion("approve_time not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveIsNull() {
            addCriterion("approve is null");
            return (Criteria) this;
        }

        public Criteria andApproveIsNotNull() {
            addCriterion("approve is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEqualTo(Byte value) {
            addCriterion("approve =", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotEqualTo(Byte value) {
            addCriterion("approve <>", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThan(Byte value) {
            addCriterion("approve >", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThanOrEqualTo(Byte value) {
            addCriterion("approve >=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThan(Byte value) {
            addCriterion("approve <", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThanOrEqualTo(Byte value) {
            addCriterion("approve <=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveIn(List<Byte> values) {
            addCriterion("approve in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotIn(List<Byte> values) {
            addCriterion("approve not in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveBetween(Byte value1, Byte value2) {
            addCriterion("approve between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotBetween(Byte value1, Byte value2) {
            addCriterion("approve not between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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