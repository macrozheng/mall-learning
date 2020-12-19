package com.macro.mall.tiny.domain;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsRole;

import java.util.List;

/**
 * Created by macro on 2020/12/9.
 */
public class AdminRoleDto extends UmsAdmin {

    private List<UmsRole> roleList;

    public List<UmsRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UmsRole> roleList) {
        this.roleList = roleList;
    }
}
