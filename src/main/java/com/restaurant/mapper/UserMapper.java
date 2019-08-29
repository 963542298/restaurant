package com.restaurant.mapper;

import com.restaurant.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface UserMapper {

    /**
     * 根据状态查询 0为未上桌 1为以上桌
     * @return
     */
    @Select("select * from user")
    List<User> selectUser();


    @Select("select * from user "
            + "where userName like #{userName} ")
    List<User> selectUserLike(@Param("userName") String userName);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Delete("delete from user where userId = #{value}")
    Integer deleteUser(Integer userId);

    /**
     * 更新状态
     */
    @Update("update user set userState=#{userState} where userId=#{userId}")
    int updateState(@Param("userState") Integer userState ,@Param("userId") Integer userId);

    /**
     * 添加用户
     */
    @Insert("insert into user(username,userage,usersex,userbirthday,useraddress,userphone,userstate) " +
            "values (" +
            "#{username},#{userage},#{usersex},#{userbirthday},#{useraddress},#{userphone},#{userstate})")
    int addUser(@Param("user")User user);

}