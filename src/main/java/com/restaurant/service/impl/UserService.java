package com.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restaurant.entity.User;
import com.restaurant.mapper.UserMapper;
import com.restaurant.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserService implements IUserSevice {

    @Autowired
   private UserMapper mapper;

    /**
     * 查询所有人员
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<User> showUsers(Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<User> list = mapper.selectUser();
        System.out.println("list  :  "+list);
        PageInfo<User> pageList = new PageInfo<User>(list);
        return pageList;
    }

    /**
     * 模糊查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<User> selectUserLike(String userName, Integer page, Integer pageSize) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10: pageSize;
        System.out.println(page + "--"+pageSize);
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        List<User> list =mapper.selectUserLike("%"+userName+"%");
        System.out.println("list  :  "+list);
        PageInfo<User> pageList = new PageInfo<User>(list);
        return pageList;
    }

    /**
     * 根据人员Id来改人员的状态
     */
    public int updateState(Integer userState, Integer userId) {
        return mapper.updateState(userState, userId);
    }

    /**
     *
     * @param userId
     * @return
     */
    public int deleteUser(Integer userId){

        return mapper.deleteUser(userId);
    }

    public int addUser(User user){

       return mapper.addUser(user);
    }
}
