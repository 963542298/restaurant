package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.User;
import com.restaurant.service.IUserSevice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.metadata.Table;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserSevice service;

    /**
     * 分页查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/showUser.action")
    public @ResponseBody PageInfo<User> showUsers(String userName,  Integer page, Integer pageSize){
        PageInfo<User> pageList=null;
        if(userName == null) {
            pageList = service.showUsers(page, pageSize);
        }else if(userName != null){
            pageList = service.selectUserLike("%"+userName+"%", page, pageSize);
        }
        System.out.println(pageList);
        return pageList;
    }

    @RequestMapping("/updateUserState.action")
    public String updateState(Integer userState, Integer userId) {
        service.updateState(userState,userId);
        return "/showUser.action";
    }

    @RequestMapping("/deleteUser.action")
    public String deleteUser(Integer userid) {
        service.deleteUser(userid);
        return "/showUser.action";
    }

    @RequestMapping("/addUser.action")
    public String addUser(User user){
        System.out.println(user);
        service.addUser(user);
        return "";
    }
}

