package com.macro.mall.tiny.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class DeviceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceInfoExample() {
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

        public Criteria andApplicationIsNull() {
            addCriterion("application is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("application is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(String value) {
            addCriterion("application =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(String value) {
            addCriterion("application <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(String value) {
            addCriterion("application >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("application >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(String value) {
            addCriterion("application <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(String value) {
            addCriterion("application <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLike(String value) {
            addCriterion("application like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotLike(String value) {
            addCriterion("application not like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<String> values) {
            addCriterion("application in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<String> values) {
            addCriterion("application not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(String value1, String value2) {
            addCriterion("application between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(String value1, String value2) {
            addCriterion("application not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andRackIdIsNull() {
            addCriterion("rack_id is null");
            return (Criteria) this;
        }

        public Criteria andRackIdIsNotNull() {
            addCriterion("rack_id is not null");
            return (Criteria) this;
        }

        public Criteria andRackIdEqualTo(Integer value) {
            addCriterion("rack_id =", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdNotEqualTo(Integer value) {
            addCriterion("rack_id <>", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdGreaterThan(Integer value) {
            addCriterion("rack_id >", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rack_id >=", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdLessThan(Integer value) {
            addCriterion("rack_id <", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdLessThanOrEqualTo(Integer value) {
            addCriterion("rack_id <=", value, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdIn(List<Integer> values) {
            addCriterion("rack_id in", values, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdNotIn(List<Integer> values) {
            addCriterion("rack_id not in", values, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdBetween(Integer value1, Integer value2) {
            addCriterion("rack_id between", value1, value2, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rack_id not between", value1, value2, "rackId");
            return (Criteria) this;
        }

        public Criteria andRackNameIsNull() {
            addCriterion("rack_name is null");
            return (Criteria) this;
        }

        public Criteria andRackNameIsNotNull() {
            addCriterion("rack_name is not null");
            return (Criteria) this;
        }

        public Criteria andRackNameEqualTo(String value) {
            addCriterion("rack_name =", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameNotEqualTo(String value) {
            addCriterion("rack_name <>", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameGreaterThan(String value) {
            addCriterion("rack_name >", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameGreaterThanOrEqualTo(String value) {
            addCriterion("rack_name >=", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameLessThan(String value) {
            addCriterion("rack_name <", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameLessThanOrEqualTo(String value) {
            addCriterion("rack_name <=", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameLike(String value) {
            addCriterion("rack_name like", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameNotLike(String value) {
            addCriterion("rack_name not like", value, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameIn(List<String> values) {
            addCriterion("rack_name in", values, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameNotIn(List<String> values) {
            addCriterion("rack_name not in", values, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameBetween(String value1, String value2) {
            addCriterion("rack_name between", value1, value2, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackNameNotBetween(String value1, String value2) {
            addCriterion("rack_name not between", value1, value2, "rackName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameIsNull() {
            addCriterion("rack_room_info_building_name is null");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameIsNotNull() {
            addCriterion("rack_room_info_building_name is not null");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameEqualTo(String value) {
            addCriterion("rack_room_info_building_name =", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameNotEqualTo(String value) {
            addCriterion("rack_room_info_building_name <>", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameGreaterThan(String value) {
            addCriterion("rack_room_info_building_name >", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("rack_room_info_building_name >=", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameLessThan(String value) {
            addCriterion("rack_room_info_building_name <", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("rack_room_info_building_name <=", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameLike(String value) {
            addCriterion("rack_room_info_building_name like", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameNotLike(String value) {
            addCriterion("rack_room_info_building_name not like", value, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameIn(List<String> values) {
            addCriterion("rack_room_info_building_name in", values, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameNotIn(List<String> values) {
            addCriterion("rack_room_info_building_name not in", values, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameBetween(String value1, String value2) {
            addCriterion("rack_room_info_building_name between", value1, value2, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoBuildingNameNotBetween(String value1, String value2) {
            addCriterion("rack_room_info_building_name not between", value1, value2, "rackRoomInfoBuildingName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameIsNull() {
            addCriterion("rack_room_info_room_name is null");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameIsNotNull() {
            addCriterion("rack_room_info_room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameEqualTo(String value) {
            addCriterion("rack_room_info_room_name =", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameNotEqualTo(String value) {
            addCriterion("rack_room_info_room_name <>", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameGreaterThan(String value) {
            addCriterion("rack_room_info_room_name >", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("rack_room_info_room_name >=", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameLessThan(String value) {
            addCriterion("rack_room_info_room_name <", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameLessThanOrEqualTo(String value) {
            addCriterion("rack_room_info_room_name <=", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameLike(String value) {
            addCriterion("rack_room_info_room_name like", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameNotLike(String value) {
            addCriterion("rack_room_info_room_name not like", value, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameIn(List<String> values) {
            addCriterion("rack_room_info_room_name in", values, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameNotIn(List<String> values) {
            addCriterion("rack_room_info_room_name not in", values, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameBetween(String value1, String value2) {
            addCriterion("rack_room_info_room_name between", value1, value2, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andRackRoomInfoRoomNameNotBetween(String value1, String value2) {
            addCriterion("rack_room_info_room_name not between", value1, value2, "rackRoomInfoRoomName");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIsNull() {
            addCriterion("install_location is null");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIsNotNull() {
            addCriterion("install_location is not null");
            return (Criteria) this;
        }

        public Criteria andInstallLocationEqualTo(String value) {
            addCriterion("install_location =", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotEqualTo(String value) {
            addCriterion("install_location <>", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationGreaterThan(String value) {
            addCriterion("install_location >", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationGreaterThanOrEqualTo(String value) {
            addCriterion("install_location >=", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLessThan(String value) {
            addCriterion("install_location <", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLessThanOrEqualTo(String value) {
            addCriterion("install_location <=", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLike(String value) {
            addCriterion("install_location like", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotLike(String value) {
            addCriterion("install_location not like", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIn(List<String> values) {
            addCriterion("install_location in", values, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotIn(List<String> values) {
            addCriterion("install_location not in", values, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationBetween(String value1, String value2) {
            addCriterion("install_location between", value1, value2, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotBetween(String value1, String value2) {
            addCriterion("install_location not between", value1, value2, "installLocation");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightIsNull() {
            addCriterion("device_pid_device_height is null");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightIsNotNull() {
            addCriterion("device_pid_device_height is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightEqualTo(String value) {
            addCriterion("device_pid_device_height =", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightNotEqualTo(String value) {
            addCriterion("device_pid_device_height <>", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightGreaterThan(String value) {
            addCriterion("device_pid_device_height >", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightGreaterThanOrEqualTo(String value) {
            addCriterion("device_pid_device_height >=", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightLessThan(String value) {
            addCriterion("device_pid_device_height <", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightLessThanOrEqualTo(String value) {
            addCriterion("device_pid_device_height <=", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightLike(String value) {
            addCriterion("device_pid_device_height like", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightNotLike(String value) {
            addCriterion("device_pid_device_height not like", value, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightIn(List<String> values) {
            addCriterion("device_pid_device_height in", values, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightNotIn(List<String> values) {
            addCriterion("device_pid_device_height not in", values, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightBetween(String value1, String value2) {
            addCriterion("device_pid_device_height between", value1, value2, "devicePidDeviceHeight");
            return (Criteria) this;
        }

        public Criteria andDevicePidDeviceHeightNotBetween(String value1, String value2) {
            addCriterion("device_pid_device_height not between", value1, value2, "devicePidDeviceHeight");
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