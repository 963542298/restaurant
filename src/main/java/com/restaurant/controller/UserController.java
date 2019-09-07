package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.User;
import com.restaurant.service.IUserSevice;
import com.restaurant.entity.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * @param role
     * @param userId
     * @return
     */
    @RequestMapping("/updateUserState.action")
    public String updateState(Integer role, Integer userId) {
        service.updateState(role,userId);
        return "/showUser.action";
    }

    @RequestMapping("/unlockUserState.action")
    public String unlockUserState(Integer role, Integer userId) {
        service.unlockUserState(role,userId);
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
    @RequestMapping("/addUser.action")
    public @ResponseBody ResultUtil addUser(User user){
        int row=0;
        String userphone=user.getUserphone();
        String regEx1 = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regEx1);
        Matcher em = p.matcher(userphone);
        if(userphone.length()==11 &&em.matches()) {
            row=service.addUser(user);
            if(row==1) {
                result.setCode(0).setMessage("添加成功");
            }else{
                result.setCode(1).setMessage("添加失败");
            }
        }else{
            result.setCode(1).setMessage("信息格式有误(比如:手机号码,生日)");
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

    /**
     *
     * @param userid
     * @return
     */
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

