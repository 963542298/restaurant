package com.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restaurant.entity.User;
import com.restaurant.mapper.AccountMapper;
import com.restaurant.mapper.UserMapper;
import com.restaurant.service.IUserSevice;
import com.restaurant.util.MD5Util;
import com.restaurant.util.PinyinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserService implements IUserSevice {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private AccountMapper accountmapper;

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
    public int updateState(Integer role, Integer userId) {
        return accountmapper.updateState(role, userId);
    }

    /**
     * 解锁用户
     * @param role
     * @param userId
     * @return
     */
    public int unlockUserState(Integer role, Integer userId){
        return accountmapper.unlockUserState(role, userId);
    }

    /**
     *
     * @param userId
     * @return
     */
    public int deleteUser(Integer userId){


        if(mapper.deleteUser(userId)>0){
            int rowCount=accountmapper.delete(userId);
            if(rowCount > 0){
                return 1;
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }

    public int addUser(User user){
        String acname=user.getUsername();
        int rowCount = mapper.addUser(user);
        if( rowCount > 0){
            String accountname=new PinyinUtil().test(acname);
            String accountpwd=MD5Util.encrypt(new PinyinUtil().test(acname));

            int userid = findUseridByUser(user);
            System.out.println(userid);
            int rowCount1 = accountmapper.insert(accountname,accountpwd,0,userid);
            if(rowCount1 > 0){
                return 1;
            } else {
                return 0;
            }
        }else{
            return 0;
        }
    }

    public int editUser(User user) {
        return mapper.editUser(user);
    }

    public  User findUserById(Integer userid){
        return mapper.findUserById(userid);
    }

    public int findUseridByUser(User user){

        return mapper.findUseridByUser(user).getUserid();
    }


}
