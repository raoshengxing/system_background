package com.rsxtar.mapper;

import com.rsxtar.dto.MenuInfoDto;
import com.rsxtar.pojo.MenuInfo;
import com.rsxtar.pojo.UserInfo;
import com.rsxtar.vo.AssignPermessionVo;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/4/1.
 */
public interface MenuInfoMapper {
    public List<MenuInfoDto> getAllMenu(int roleId);
    public List<MenuInfoDto> getAllMenu1(int roleId);
    public int menuToEmpty(int roleId);
    public int queryExist(Map map);
    public int updateRMTable (Map map);
    public int addRM (Map map);
    public int addRMByAssignPermessionVo(AssignPermessionVo assignPermessionVo);
    public List<MenuInfo> getMenuInfoByUser(UserInfo userInfo);
}
