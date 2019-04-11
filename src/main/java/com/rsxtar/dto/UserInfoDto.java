package com.rsxtar.dto;

import com.rsxtar.pojo.UserInfo;
import com.rsxtar.tools.SplitePageBean;

import java.util.List;

/**
 * Created by DELL on 2019/3/29.
 */
public class UserInfoDto {
    //当前页数据
    List<UserInfo> userInfoList;
    //分页数据
    SplitePageBean splitePageBean;


    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

}
