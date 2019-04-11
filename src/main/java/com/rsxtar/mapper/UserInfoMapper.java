package com.rsxtar.mapper;

import com.rsxtar.pojo.UserInfo;
import com.rsxtar.vo.UserInfoVo;


import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/3/27.
 */
public interface UserInfoMapper {

    public UserInfo loginCheck(UserInfo userInfo);

    public int addUserInfo(UserInfo userInfo);

    public List<UserInfo> getUserInfoMapById(int id);

    public int updateUserInfo(UserInfo userInfo);
    public int deleteUserInfoById(int id);
    public List<UserInfo> findAll();
    public List<UserInfo> getUserInfoBy(UserInfo userInfo);


    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(UserInfoVo userInfoVo);

    public int deleteBySel(Map<String,List> map);

}
