package com.rsxtar.controller;


import com.rsxtar.dto.UserInfoDto;
import com.rsxtar.pojo.UserInfo;
import com.rsxtar.service.UserService;
import com.rsxtar.service.impl.UserServiceImpl;

import com.rsxtar.tools.SplitePageBean;
import com.rsxtar.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by DELL on 2019/3/28.
 */
@Controller
public class MyController {


    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public String test(){
        System.out.println("inner test");
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody UserInfo userInfo, HttpSession httpSession){
        Boolean flag = false;
        System.out.println("username="+userInfo.getUsername()+",password="+userInfo.getPassword());

        UserInfo user = userService.loginCheck(userInfo);
        if(user!=null){
            httpSession.setAttribute("user",user);
            flag = true;
        }

        return flag.toString();
    }
    @ResponseBody
    @RequestMapping(value = "userInfoList1",method = RequestMethod.POST)
    public Object getUserInfoBy(@RequestBody(required = false) UserInfo userInfo){
        List<UserInfo> userInfos = userService.getUserInfoBy(userInfo);
        System.out.println(userInfos);
        return userInfos;
    }



//    updateUserInfo
    @ResponseBody
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public Object updateUserInfo(@RequestBody(required = false) UserInfo userInfo){
        if(userInfo.getUserId()==0){
            return false+"";
        }
        boolean flag = this.userService.updateUserInfo(userInfo);
        return flag;
    }

    @ResponseBody
    @RequestMapping(value = "deleteUserInfoById",method = RequestMethod.POST)
    public Object deleteUser(@RequestBody(required = false) UserInfo userInfo){

        if(userInfo.getUserId()==0){
            return false+"";
        }
        boolean flag = this.userService.deleteUserInfoById(userInfo.getUserId());
        return flag;
    }
    @ResponseBody
    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    public String addUserInfo(@RequestBody(required = false) UserInfo userInfo){


        Boolean flag = this.userService.addUserInfo(userInfo);
        return flag.toString();
    }

    @ResponseBody
    @RequestMapping(value = "userInfoList",method = RequestMethod.POST)
    public Object userInfoList(@RequestBody(required = false) UserInfoVo userInfoVo){

        //当前是第几页、每页多少行
//        UserInfoVo???
        List<UserInfo> userInfoList = this.userService.getUserInfosPageBy(userInfoVo);
//        System.out.println(userInfoList.toString()+"11111");
        //返回集合
        //返回页面
        SplitePageBean splitePageBean = new SplitePageBean();
        int count = this.userService.getCount(userInfoVo);
        splitePageBean.setCurrentPage(userInfoVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setDataCount(count);
        splitePageBean.setPageCount(count%2==0?count/2:count/2+1);
        UserInfoDto dto = new UserInfoDto();
        dto.setUserInfoList(userInfoList);
        dto.setSplitePageBean(splitePageBean);
        return dto;
    }
    @RequestMapping(value = "deleteUserSel")
    public Object deleteUserSel(@RequestParam(value = "ids[]")  List<Integer>  ids){

        Map<String, List> map = new HashMap<String, List>();
        map.put("ids",ids);
        userService.deleteBySel(map);

        return "user";
    }
    @ResponseBody
    @RequestMapping(value = "getUser")
    public Object  getUser ( HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        System.out.println(user);
        return user;
    }



}
