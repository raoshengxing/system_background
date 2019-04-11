package com.rsxtar.vo;

import com.rsxtar.tools.SplitePageBean;

public class RolePageVo {
    int roleId;
    String roleName;
    SplitePageBean splitePageBean;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "RolePageVo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
