package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.ResultUtil;
import com.restaurant.entity.User;
import com.restaurant.service.IUserSevice;
import com.restaurant.entity.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.metadata.Table;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private IUserSevice service;

    // 返回前端数据载体
    private ResultUtil result=new ResultUtil();

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

    /**
     * 更新状态(锁定)
     * @param userState
     * @param userId
     * @return
     */
    @RequestMapping("/updateUserState.action")
    public String updateState(Integer userState, Integer userId) {
        service.updateState(userState,userId);
        return "/showUser.action";
    }

    @RequestMapping("/unlockUserState.action")
    public String unlockUserState(Integer userState, Integer userId) {
        service.unlockUserState(userState,userId);
        return "/showUser.action";
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    @RequestMapping("/deleteUser.action")
    public String deleteUser(Integer userid) {
        service.deleteUser(userid);
        return "/showUser.action";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public @ResponseBody ResultUtil addUser(User user){
        if(user.getUserphone().length()==11) {
            int row = service.addUser(user);
        if (row == 1) {
            result.setCode(0).setMessage("添加成功");
        } else {
            result.setCode(1);
        }
    }else{
        result.setCode(1);
    }
        return result;
    }

    /**
     * 编辑用户信息
     */
    @RequestMapping("/editUser.action")
    public @ResponseBody ResultUtil editUser(User user){
        System.out.println(user);
        int row=service.editUser(user);
        if(row==1){
            result.setCode(0).setMessage("编辑成功");
        }else{
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/findUserById.action")
    public @ResponseBody ResultUtil findUserById(Integer userid){
        User user=service.findUserById(userid);
        if(user !=null){
            result.setCode(0).setData(user);
        }else {
            result.setCode(1);
        }
        return result;
    }
}

