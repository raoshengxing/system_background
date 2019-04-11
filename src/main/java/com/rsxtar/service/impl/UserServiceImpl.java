package com.rsxtar.service.impl;

import com.rsxtar.mapper.UserInfoMapper;
import com.rsxtar.pojo.UserInfo;
import com.rsxtar.service.UserService;
import com.rsxtar.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo loginCheck(UserInfo userInfo) {
        UserInfo check = userInfoMapper.loginCheck(userInfo);

        return check;
    }

    @Transactional
    public boolean addUserInfo(UserInfo userInfo)  {
        int count = this.userInfoMapper.addUserInfo(userInfo);

        if(count>0){
            return true;
        }

        return false;

    }

    public UserInfo getUserInfoMapById(int id) {
        List<UserInfo> userInfos = userInfoMapper.getUserInfoMapById(id);

        return userInfos.get(0);
    }

    public boolean updateUserInfo(UserInfo userInfo) {
        int i = userInfoMapper.updateUserInfo(userInfo);
        if (i>0){
            return true;
        }
        return false;
    }

    public boolean deleteUserInfoById(int id) {
        int i = userInfoMapper.deleteUserInfoById(id);
        if (i>0){
            return true;
        }
        return false;
    }

    public List<UserInfo> getAll() {
        return userInfoMapper.findAll();
    }

    public List<UserInfo> getUserInfoBy(UserInfo userInfo) {
        return userInfoMapper.getUserInfoBy(userInfo);
    }

    public int getCount(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getCount(userInfoVo);
    }

    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getUserInfosPageBy(userInfoVo);
    }

    public int deleteBySel(Map<String, List> map) {
        int i = userInfoMapper.deleteBySel(map);
        return i;
    }


}
