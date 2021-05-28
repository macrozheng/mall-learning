package com.macro.mall.tiny.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class RackInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RackInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameIsNull() {
            addCriterion("room_info_room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameIsNotNull() {
            addCriterion("room_info_room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameEqualTo(String value) {
            addCriterion("room_info_room_name =", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameNotEqualTo(String value) {
            addCriterion("room_info_room_name <>", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameGreaterThan(String value) {
            addCriterion("room_info_room_name >", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_info_room_name >=", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameLessThan(String value) {
            addCriterion("room_info_room_name <", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_info_room_name <=", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameLike(String value) {
            addCriterion("room_info_room_name like", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameNotLike(String value) {
            addCriterion("room_info_room_name not like", value, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameIn(List<String> values) {
            addCriterion("room_info_room_name in", values, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameNotIn(List<String> values) {
            addCriterion("room_info_room_name not in", values, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameBetween(String value1, String value2) {
            addCriterion("room_info_room_name between", value1, value2, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_info_room_name not between", value1, value2, "roomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameIsNull() {
            addCriterion("room_info_building_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameIsNotNull() {
            addCriterion("room_info_building_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameEqualTo(String value) {
            addCriterion("room_info_building_name =", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameNotEqualTo(String value) {
            addCriterion("room_info_building_name <>", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameGreaterThan(String value) {
            addCriterion("room_info_building_name >", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_info_building_name >=", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameLessThan(String value) {
            addCriterion("room_info_building_name <", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("room_info_building_name <=", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameLike(String value) {
            addCriterion("room_info_building_name like", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameNotLike(String value) {
            addCriterion("room_info_building_name not like", value, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameIn(List<String> values) {
            addCriterion("room_info_building_name in", values, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameNotIn(List<String> values) {
            addCriterion("room_info_building_name not in", values, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameBetween(String value1, String value2) {
            addCriterion("room_info_building_name between", value1, value2, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRoomInfoBuildingNameNotBetween(String value1, String value2) {
            addCriterion("room_info_building_name not between", value1, value2, "roomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(Integer value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(Integer value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(Integer value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(Integer value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(Integer value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(Integer value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<Integer> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<Integer> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(Integer value1, Integer value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(Integer value1, Integer value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(Integer value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(Integer value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(Integer value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(Integer value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(Integer value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(Integer value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<Integer> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<Integer> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(Integer value1, Integer value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(Integer value1, Integer value2) {
            addCriterion("y not between", value1, value2, "y");
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