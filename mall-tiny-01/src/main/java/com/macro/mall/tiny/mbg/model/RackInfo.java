package com.macro.mall.tiny.mbg.model;


import java.io.Serializable;

public class RackInfo implements Serializable {
    private Integer id;

    private String name;

    private Integer height;

    private String roomInfoRoomName;

    private String roomInfoBuildingName;

    private Integer x;

    private Integer y;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getRoomInfoRoomName() {
        return roomInfoRoomName;
    }

    public void setRoomInfoRoomName(String roomInfoRoomName) {
        this.roomInfoRoomName = roomInfoRoomName;
    }

    public String getRoomInfoBuildingName() {
        return roomInfoBuildingName;
    }

    public void setRoomInfoBuildingName(String roomInfoBuildingName) {
        this.roomInfoBuildingName = roomInfoBuildingName;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", height=").append(height);
        sb.append(", roomInfoRoomName=").append(roomInfoRoomName);
        sb.append(", roomInfoBuildingName=").append(roomInfoBuildingName);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}