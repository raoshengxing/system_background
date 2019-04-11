package com.rsxtar.mapper;

import com.rsxtar.dto.RoleInfoDto;
import com.rsxtar.pojo.RoleInfo;
import com.rsxtar.tools.SplitePageBean;
import com.rsxtar.vo.RolePageVo;
import com.rsxtar.vo.RoleVo;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
public interface RoleInfoMapper {

    public List<RoleInfoDto> getRoleByUserId(int userId);
    public List<RoleInfo> getAllRole();
    public List<RoleInfo> getRoleInfosPageBy(SplitePageBean splitePageBean);
    public int removeRoleByUserId(int userId);
    public int addRoleByUserId(RoleVo roleVo);
    public int deleteRoleById(int roleId);

}
