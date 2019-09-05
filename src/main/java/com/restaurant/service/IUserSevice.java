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
    public PageInfo<User> showUsers( Integer page, Integer pageSize);

    /**
     * 模糊查询
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<User> selectUserLike(String userName,Integer page, Integer pageSize);

    /**
     * 更新状态
     * @param userState
     * @param userId
     * @return
     */
    public int updateState(Integer userState, Integer userId);

    public int unlockUserState(Integer userState, Integer userId);

    /**
     * 删除用户
     */
    int deleteUser(Integer userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    public int editUser(User user);

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return
     */
    public User findUserById(Integer userid);
}
