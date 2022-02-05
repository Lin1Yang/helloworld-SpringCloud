package com.inossem.wms.model.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImgFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImgFileExample() {
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

        public Criteria andImgCodeIsNull() {
            addCriterion("img_code is null");
            return (Criteria) this;
        }

        public Criteria andImgCodeIsNotNull() {
            addCriterion("img_code is not null");
            return (Criteria) this;
        }

        public Criteria andImgCodeEqualTo(String value) {
            addCriterion("img_code =", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeNotEqualTo(String value) {
            addCriterion("img_code <>", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeGreaterThan(String value) {
            addCriterion("img_code >", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("img_code >=", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeLessThan(String value) {
            addCriterion("img_code <", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeLessThanOrEqualTo(String value) {
            addCriterion("img_code <=", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeLike(String value) {
            addCriterion("img_code like", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeNotLike(String value) {
            addCriterion("img_code not like", value, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeIn(List<String> values) {
            addCriterion("img_code in", values, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeNotIn(List<String> values) {
            addCriterion("img_code not in", values, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeBetween(String value1, String value2) {
            addCriterion("img_code between", value1, value2, "imgCode");
            return (Criteria) this;
        }

        public Criteria andImgCodeNotBetween(String value1, String value2) {
            addCriterion("img_code not between", value1, value2, "imgCode");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andImgNameIsNull() {
            addCriterion("img_name is null");
            return (Criteria) this;
        }

        public Criteria andImgNameIsNotNull() {
            addCriterion("img_name is not null");
            return (Criteria) this;
        }

        public Criteria andImgNameEqualTo(String value) {
            addCriterion("img_name =", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotEqualTo(String value) {
            addCriterion("img_name <>", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameGreaterThan(String value) {
            addCriterion("img_name >", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("img_name >=", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLessThan(String value) {
            addCriterion("img_name <", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLessThanOrEqualTo(String value) {
            addCriterion("img_name <=", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameLike(String value) {
            addCriterion("img_name like", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotLike(String value) {
            addCriterion("img_name not like", value, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameIn(List<String> values) {
            addCriterion("img_name in", values, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotIn(List<String> values) {
            addCriterion("img_name not in", values, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameBetween(String value1, String value2) {
            addCriterion("img_name between", value1, value2, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameNotBetween(String value1, String value2) {
            addCriterion("img_name not between", value1, value2, "imgName");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedIsNull() {
            addCriterion("img_name_converted is null");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedIsNotNull() {
            addCriterion("img_name_converted is not null");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedEqualTo(String value) {
            addCriterion("img_name_converted =", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedNotEqualTo(String value) {
            addCriterion("img_name_converted <>", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedGreaterThan(String value) {
            addCriterion("img_name_converted >", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedGreaterThanOrEqualTo(String value) {
            addCriterion("img_name_converted >=", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedLessThan(String value) {
            addCriterion("img_name_converted <", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedLessThanOrEqualTo(String value) {
            addCriterion("img_name_converted <=", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedLike(String value) {
            addCriterion("img_name_converted like", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedNotLike(String value) {
            addCriterion("img_name_converted not like", value, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedIn(List<String> values) {
            addCriterion("img_name_converted in", values, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedNotIn(List<String> values) {
            addCriterion("img_name_converted not in", values, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedBetween(String value1, String value2) {
            addCriterion("img_name_converted between", value1, value2, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgNameConvertedNotBetween(String value1, String value2) {
            addCriterion("img_name_converted not between", value1, value2, "imgNameConverted");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameIsNull() {
            addCriterion("img_orig_name is null");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameIsNotNull() {
            addCriterion("img_orig_name is not null");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameEqualTo(String value) {
            addCriterion("img_orig_name =", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameNotEqualTo(String value) {
            addCriterion("img_orig_name <>", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameGreaterThan(String value) {
            addCriterion("img_orig_name >", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameGreaterThanOrEqualTo(String value) {
            addCriterion("img_orig_name >=", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameLessThan(String value) {
            addCriterion("img_orig_name <", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameLessThanOrEqualTo(String value) {
            addCriterion("img_orig_name <=", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameLike(String value) {
            addCriterion("img_orig_name like", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameNotLike(String value) {
            addCriterion("img_orig_name not like", value, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameIn(List<String> values) {
            addCriterion("img_orig_name in", values, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameNotIn(List<String> values) {
            addCriterion("img_orig_name not in", values, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameBetween(String value1, String value2) {
            addCriterion("img_orig_name between", value1, value2, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgOrigNameNotBetween(String value1, String value2) {
            addCriterion("img_orig_name not between", value1, value2, "imgOrigName");
            return (Criteria) this;
        }

        public Criteria andImgExtIsNull() {
            addCriterion("img_ext is null");
            return (Criteria) this;
        }

        public Criteria andImgExtIsNotNull() {
            addCriterion("img_ext is not null");
            return (Criteria) this;
        }

        public Criteria andImgExtEqualTo(String value) {
            addCriterion("img_ext =", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtNotEqualTo(String value) {
            addCriterion("img_ext <>", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtGreaterThan(String value) {
            addCriterion("img_ext >", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtGreaterThanOrEqualTo(String value) {
            addCriterion("img_ext >=", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtLessThan(String value) {
            addCriterion("img_ext <", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtLessThanOrEqualTo(String value) {
            addCriterion("img_ext <=", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtLike(String value) {
            addCriterion("img_ext like", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtNotLike(String value) {
            addCriterion("img_ext not like", value, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtIn(List<String> values) {
            addCriterion("img_ext in", values, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtNotIn(List<String> values) {
            addCriterion("img_ext not in", values, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtBetween(String value1, String value2) {
            addCriterion("img_ext between", value1, value2, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgExtNotBetween(String value1, String value2) {
            addCriterion("img_ext not between", value1, value2, "imgExt");
            return (Criteria) this;
        }

        public Criteria andImgSizeIsNull() {
            addCriterion("img_size is null");
            return (Criteria) this;
        }

        public Criteria andImgSizeIsNotNull() {
            addCriterion("img_size is not null");
            return (Criteria) this;
        }

        public Criteria andImgSizeEqualTo(Integer value) {
            addCriterion("img_size =", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotEqualTo(Integer value) {
            addCriterion("img_size <>", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeGreaterThan(Integer value) {
            addCriterion("img_size >", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_size >=", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeLessThan(Integer value) {
            addCriterion("img_size <", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeLessThanOrEqualTo(Integer value) {
            addCriterion("img_size <=", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeIn(List<Integer> values) {
            addCriterion("img_size in", values, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotIn(List<Integer> values) {
            addCriterion("img_size not in", values, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeBetween(Integer value1, Integer value2) {
            addCriterion("img_size between", value1, value2, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("img_size not between", value1, value2, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgMd5IsNull() {
            addCriterion("img_md5 is null");
            return (Criteria) this;
        }

        public Criteria andImgMd5IsNotNull() {
            addCriterion("img_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andImgMd5EqualTo(String value) {
            addCriterion("img_md5 =", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5NotEqualTo(String value) {
            addCriterion("img_md5 <>", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5GreaterThan(String value) {
            addCriterion("img_md5 >", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5GreaterThanOrEqualTo(String value) {
            addCriterion("img_md5 >=", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5LessThan(String value) {
            addCriterion("img_md5 <", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5LessThanOrEqualTo(String value) {
            addCriterion("img_md5 <=", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5Like(String value) {
            addCriterion("img_md5 like", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5NotLike(String value) {
            addCriterion("img_md5 not like", value, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5In(List<String> values) {
            addCriterion("img_md5 in", values, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5NotIn(List<String> values) {
            addCriterion("img_md5 not in", values, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5Between(String value1, String value2) {
            addCriterion("img_md5 between", value1, value2, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andImgMd5NotBetween(String value1, String value2) {
            addCriterion("img_md5 not between", value1, value2, "imgMd5");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNull() {
            addCriterion("modify_user_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNotNull() {
            addCriterion("modify_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdEqualTo(Integer value) {
            addCriterion("modify_user_id =", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotEqualTo(Integer value) {
            addCriterion("modify_user_id <>", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThan(Integer value) {
            addCriterion("modify_user_id >", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify_user_id >=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThan(Integer value) {
            addCriterion("modify_user_id <", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("modify_user_id <=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIn(List<Integer> values) {
            addCriterion("modify_user_id in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotIn(List<Integer> values) {
            addCriterion("modify_user_id not in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdBetween(Integer value1, Integer value2) {
            addCriterion("modify_user_id between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("modify_user_id not between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andImgExt0IsNull() {
            addCriterion("img_ext0 is null");
            return (Criteria) this;
        }

        public Criteria andImgExt0IsNotNull() {
            addCriterion("img_ext0 is not null");
            return (Criteria) this;
        }

        public Criteria andImgExt0EqualTo(String value) {
            addCriterion("img_ext0 =", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0NotEqualTo(String value) {
            addCriterion("img_ext0 <>", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0GreaterThan(String value) {
            addCriterion("img_ext0 >", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0GreaterThanOrEqualTo(String value) {
            addCriterion("img_ext0 >=", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0LessThan(String value) {
            addCriterion("img_ext0 <", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0LessThanOrEqualTo(String value) {
            addCriterion("img_ext0 <=", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0Like(String value) {
            addCriterion("img_ext0 like", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0NotLike(String value) {
            addCriterion("img_ext0 not like", value, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0In(List<String> values) {
            addCriterion("img_ext0 in", values, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0NotIn(List<String> values) {
            addCriterion("img_ext0 not in", values, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0Between(String value1, String value2) {
            addCriterion("img_ext0 between", value1, value2, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt0NotBetween(String value1, String value2) {
            addCriterion("img_ext0 not between", value1, value2, "imgExt0");
            return (Criteria) this;
        }

        public Criteria andImgExt1IsNull() {
            addCriterion("img_ext1 is null");
            return (Criteria) this;
        }

        public Criteria andImgExt1IsNotNull() {
            addCriterion("img_ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andImgExt1EqualTo(String value) {
            addCriterion("img_ext1 =", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1NotEqualTo(String value) {
            addCriterion("img_ext1 <>", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1GreaterThan(String value) {
            addCriterion("img_ext1 >", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1GreaterThanOrEqualTo(String value) {
            addCriterion("img_ext1 >=", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1LessThan(String value) {
            addCriterion("img_ext1 <", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1LessThanOrEqualTo(String value) {
            addCriterion("img_ext1 <=", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1Like(String value) {
            addCriterion("img_ext1 like", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1NotLike(String value) {
            addCriterion("img_ext1 not like", value, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1In(List<String> values) {
            addCriterion("img_ext1 in", values, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1NotIn(List<String> values) {
            addCriterion("img_ext1 not in", values, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1Between(String value1, String value2) {
            addCriterion("img_ext1 between", value1, value2, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt1NotBetween(String value1, String value2) {
            addCriterion("img_ext1 not between", value1, value2, "imgExt1");
            return (Criteria) this;
        }

        public Criteria andImgExt2IsNull() {
            addCriterion("img_ext2 is null");
            return (Criteria) this;
        }

        public Criteria andImgExt2IsNotNull() {
            addCriterion("img_ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andImgExt2EqualTo(String value) {
            addCriterion("img_ext2 =", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2NotEqualTo(String value) {
            addCriterion("img_ext2 <>", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2GreaterThan(String value) {
            addCriterion("img_ext2 >", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2GreaterThanOrEqualTo(String value) {
            addCriterion("img_ext2 >=", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2LessThan(String value) {
            addCriterion("img_ext2 <", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2LessThanOrEqualTo(String value) {
            addCriterion("img_ext2 <=", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2Like(String value) {
            addCriterion("img_ext2 like", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2NotLike(String value) {
            addCriterion("img_ext2 not like", value, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2In(List<String> values) {
            addCriterion("img_ext2 in", values, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2NotIn(List<String> values) {
            addCriterion("img_ext2 not in", values, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2Between(String value1, String value2) {
            addCriterion("img_ext2 between", value1, value2, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt2NotBetween(String value1, String value2) {
            addCriterion("img_ext2 not between", value1, value2, "imgExt2");
            return (Criteria) this;
        }

        public Criteria andImgExt3IsNull() {
            addCriterion("img_ext3 is null");
            return (Criteria) this;
        }

        public Criteria andImgExt3IsNotNull() {
            addCriterion("img_ext3 is not null");
            return (Criteria) this;
        }

        public Criteria andImgExt3EqualTo(String value) {
            addCriterion("img_ext3 =", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3NotEqualTo(String value) {
            addCriterion("img_ext3 <>", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3GreaterThan(String value) {
            addCriterion("img_ext3 >", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3GreaterThanOrEqualTo(String value) {
            addCriterion("img_ext3 >=", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3LessThan(String value) {
            addCriterion("img_ext3 <", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3LessThanOrEqualTo(String value) {
            addCriterion("img_ext3 <=", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3Like(String value) {
            addCriterion("img_ext3 like", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3NotLike(String value) {
            addCriterion("img_ext3 not like", value, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3In(List<String> values) {
            addCriterion("img_ext3 in", values, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3NotIn(List<String> values) {
            addCriterion("img_ext3 not in", values, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3Between(String value1, String value2) {
            addCriterion("img_ext3 between", value1, value2, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt3NotBetween(String value1, String value2) {
            addCriterion("img_ext3 not between", value1, value2, "imgExt3");
            return (Criteria) this;
        }

        public Criteria andImgExt4IsNull() {
            addCriterion("img_ext4 is null");
            return (Criteria) this;
        }

        public Criteria andImgExt4IsNotNull() {
            addCriterion("img_ext4 is not null");
            return (Criteria) this;
        }

        public Criteria andImgExt4EqualTo(String value) {
            addCriterion("img_ext4 =", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4NotEqualTo(String value) {
            addCriterion("img_ext4 <>", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4GreaterThan(String value) {
            addCriterion("img_ext4 >", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4GreaterThanOrEqualTo(String value) {
            addCriterion("img_ext4 >=", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4LessThan(String value) {
            addCriterion("img_ext4 <", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4LessThanOrEqualTo(String value) {
            addCriterion("img_ext4 <=", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4Like(String value) {
            addCriterion("img_ext4 like", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4NotLike(String value) {
            addCriterion("img_ext4 not like", value, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4In(List<String> values) {
            addCriterion("img_ext4 in", values, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4NotIn(List<String> values) {
            addCriterion("img_ext4 not in", values, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4Between(String value1, String value2) {
            addCriterion("img_ext4 between", value1, value2, "imgExt4");
            return (Criteria) this;
        }

        public Criteria andImgExt4NotBetween(String value1, String value2) {
            addCriterion("img_ext4 not between", value1, value2, "imgExt4");
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