package com.rsxtar.dto;

import com.rsxtar.pojo.RoleInfo;
import com.rsxtar.tools.SplitePageBean;

import java.util.List;

public class RolePageDto {
    List<RoleInfo> roleInfoList;
    SplitePageBean splitePageBean;

    public List<RoleInfo> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RoleInfo> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "RolePageDto{" +
                "roleInfoList=" + roleInfoList +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
