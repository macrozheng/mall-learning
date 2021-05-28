package com.macro.mall.tiny.mbg.model;

import java.io.Serializable;

public class DeviceInfo implements Serializable {
    private Integer id;

    private String application;

    private Integer rackId;

    private String rackName;

    private String rackRoomInfoBuildingName;

    private String rackRoomInfoRoomName;

    private String installLocation;

    private String devicePidDeviceHeight;

    private String image;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Integer getRackId() {
        return rackId;
    }

    public void setRackId(Integer rackId) {
        this.rackId = rackId;
    }

    public String getRackName() {
        return rackName;
    }

    public void setRackName(String rackName) {
        this.rackName = rackName;
    }

    public String getRackRoomInfoBuildingName() {
        return rackRoomInfoBuildingName;
    }

    public void setRackRoomInfoBuildingName(String rackRoomInfoBuildingName) {
        this.rackRoomInfoBuildingName = rackRoomInfoBuildingName;
    }

    public String getRackRoomInfoRoomName() {
        return rackRoomInfoRoomName;
    }

    public void setRackRoomInfoRoomName(String rackRoomInfoRoomName) {
        this.rackRoomInfoRoomName = rackRoomInfoRoomName;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getDevicePidDeviceHeight() {
        return devicePidDeviceHeight;
    }

    public void setDevicePidDeviceHeight(String devicePidDeviceHeight) {
        this.devicePidDeviceHeight = devicePidDeviceHeight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", application=").append(application);
        sb.append(", rackId=").append(rackId);
        sb.append(", rackName=").append(rackName);
        sb.append(", rackRoomInfoBuildingName=").append(rackRoomInfoBuildingName);
        sb.append(", rackRoomInfoRoomName=").append(rackRoomInfoRoomName);
        sb.append(", installLocation=").append(installLocation);
        sb.append(", devicePidDeviceHeight=").append(devicePidDeviceHeight);
        sb.append(", image=").append(image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}