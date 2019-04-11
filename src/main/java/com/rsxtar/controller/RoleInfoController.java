package com.rsxtar.controller;


import com.rsxtar.dto.RoleInfoDto;

import com.rsxtar.dto.RolePageDto;
import com.rsxtar.pojo.RoleInfo;
import com.rsxtar.service.RoleService;
import com.rsxtar.tools.SplitePageBean;
import com.rsxtar.vo.RolePageVo;
import com.rsxtar.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleInfoController {
    @Autowired
    RoleService service;
    @RequestMapping(value = "getRoleInfoByUserId",method = RequestMethod.POST)
    public List<RoleInfoDto> getRoleInfoByUserId(@RequestParam(required = false) int userId){
        return service.getRoleByUserId(userId);
    }

    @RequestMapping(value = "addRoleByUserId")
    public int addRoleByUserId(@RequestBody(required = false) RoleVo roleVo){
        System.out.println(roleVo);
        return service.addRoleByUserId(roleVo);
    }
    @RequestMapping(value = "getAllRole",method = RequestMethod.POST)
    public Object  getAllRole(){

        return service.getAllRole();
    }
    @RequestMapping(value = "deleteRoleById")
    public int deleteRoleById(@RequestParam int roleId){
        System.out.println(roleId);
        return service.deleteRoleById(roleId);
    }
    @RequestMapping(value = "getRoleInfosPageBy")
    public Object getRoleInfosPageBy(@RequestBody(required = false) SplitePageBean splitePageBean){


        List<RoleInfo> page = service.getRoleInfosPageBy(splitePageBean);
        int count = service.getAllRole().size();
        splitePageBean.setDataCount(count);
        splitePageBean.setPageCount(count%2==0?count/2:count/2+1);
        RolePageDto rolePageDto = new RolePageDto();
        rolePageDto.setRoleInfoList(page);
        rolePageDto.setSplitePageBean(splitePageBean);
        System.out.println(splitePageBean);
        return rolePageDto;
    }

}
