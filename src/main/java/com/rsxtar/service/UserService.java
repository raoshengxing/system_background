package com.rsxtar.service;

import com.rsxtar.pojo.UserInfo;
import com.rsxtar.vo.UserInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {

    public UserInfo loginCheck(UserInfo userInfo);

    public boolean addUserInfo(UserInfo userInfo);

    UserInfo getUserInfoMapById(int id);
    boolean updateUserInfo(UserInfo userInfo);
    boolean deleteUserInfoById(int id);
    List<UserInfo> getAll();
    List<UserInfo> getUserInfoBy(UserInfo userInfo);
    public int getCount(UserInfoVo userInfoVo);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    public int deleteBySel(Map<String,List> map);
}
