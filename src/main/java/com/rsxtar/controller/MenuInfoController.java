package com.rsxtar.controller;

import com.rsxtar.pojo.UserInfo;
import com.rsxtar.service.MenuService;
import com.rsxtar.vo.AssignPermessionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 2019/4/1.
 */
//声明这个control是一个restful风格的control
//等同于@ResponseBody+@Controller
@RestController
public class MenuInfoController {

    @Autowired
    MenuService menuService;

    @RequestMapping("getAllMenu")
    public Object getAllMenu(@RequestParam int roleId){

        return menuService.getAllMenu(roleId);
    }
    @RequestMapping("getAllMenu1")
    public Object getAllMenu1(@RequestParam int roleId){

        return menuService.getAllMenu1(roleId);
    }

    @RequestMapping("assignPermissionController")
    public Object assignPermission(@RequestBody AssignPermessionVo vo){
        System.out.println(vo);

        return menuService.modifyMenuByRoleId(vo);
    }
    @RequestMapping("getMenuInfoByUser")
    public Object getMenuInfoByUser(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if (user==null){
            return "gun";
        }
        return menuService.getMenuInfoByUser(user);
    }
}
