package com.rsxtar.service;

import com.rsxtar.dto.MenuInfoDto;
import com.rsxtar.pojo.MenuInfo;
import com.rsxtar.pojo.UserInfo;
import com.rsxtar.vo.AssignPermessionVo;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/4/1.
 */
public interface MenuService {
    public List<MenuInfoDto> getAllMenu(int roleId);
    public List<MenuInfoDto> getAllMenu1(int roleId);
    public int modifyMenuByRoleId(AssignPermessionVo assignPermessionVo);
    public List<MenuInfo> getMenuInfoByUser(UserInfo userInfo);
}
