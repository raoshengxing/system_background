package com.rsxtar.service.impl;

import com.rsxtar.dto.RoleInfoDto;
import com.rsxtar.mapper.RoleInfoMapper;
import com.rsxtar.pojo.RoleInfo;
import com.rsxtar.service.RoleService;
import com.rsxtar.tools.SplitePageBean;
import com.rsxtar.vo.RolePageVo;
import com.rsxtar.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleInfoMapper roleInfoMapper;
    public List<RoleInfoDto> getRoleByUserId(int userId) {
        return roleInfoMapper.getRoleByUserId(userId);
    }
    @Transactional
    public int addRoleByUserId(RoleVo roleVo) {

        int i = roleInfoMapper.removeRoleByUserId(roleVo.getUserId());
        System.out.println(i);

        return roleInfoMapper.addRoleByUserId(roleVo);
    }

    public List<RoleInfo> getAllRole() {

        return  roleInfoMapper.getAllRole();
    }

    public int deleteRoleById(int roleId) {
        return roleInfoMapper.deleteRoleById(roleId);
    }

    public List<RoleInfo> getRoleInfosPageBy(SplitePageBean splitePageBean) {

        return roleInfoMapper.getRoleInfosPageBy(splitePageBean);
    }
}
