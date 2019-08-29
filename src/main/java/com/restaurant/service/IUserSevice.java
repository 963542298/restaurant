package com.restaurant.service;


import com.github.pagehelper.PageInfo;
import com.restaurant.entity.User;

public interface IUserSevice {

    /**
     * 查询所有用户
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<User> showUsers(Integer page, Integer pageSize);

    /**
     * 模糊查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<User> selectUserLike(String userName, Integer page, Integer pageSize);

    /**
     * 更新状态
     * @param userState
     * @param userId
     * @return
     */
    public int updateState(Integer userState, Integer userId);

    /**
     * 删除用户
     */
    int deleteUser(Integer userId);

    public int addUser(User user);
}
