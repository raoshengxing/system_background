package com.rsxtar.service.impl;

import com.rsxtar.dto.MenuInfoDto;
import com.rsxtar.mapper.MenuInfoMapper;
import com.rsxtar.pojo.MenuInfo;
import com.rsxtar.pojo.UserInfo;
import com.rsxtar.service.MenuService;
import com.rsxtar.vo.AssignPermessionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/4/1.
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoDto> getAllMenu(int roleId) {
        return menuInfoMapper.getAllMenu(roleId);
    }
    public List<MenuInfoDto> getAllMenu1(int roleId) {
        return menuInfoMapper.getAllMenu1(roleId);
    }

    @Transactional
    public int modifyMenuByRoleId(AssignPermessionVo assignPermessionVo){
        int rSet = -1;
        int emptyNum = menuInfoMapper.menuToEmpty(assignPermessionVo.getRoleId());
        if (emptyNum==0){
             rSet = menuInfoMapper.addRMByAssignPermessionVo(assignPermessionVo);
            return rSet;
        }else {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("roleId",assignPermessionVo.getRoleId());
            for (int i =0; i<assignPermessionVo.getMenuIds().size();i++){
                map.put("menuId",assignPermessionVo.getMenuIds().get(i));

                     rSet = menuInfoMapper.queryExist(map);
                System.out.println("rSet:"+rSet);
                if (rSet==0){
                    menuInfoMapper.addRM(map);
                }else {

                    menuInfoMapper.updateRMTable(map);

                }
            }
            return rSet;
        }
    }

    public List<MenuInfo> getMenuInfoByUser(UserInfo userInfo) {
        return menuInfoMapper.getMenuInfoByUser(userInfo);
    }
}
