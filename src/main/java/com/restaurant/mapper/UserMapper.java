package com.restaurant.mapper;

import com.restaurant.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.*;

public interface UserMapper {

    /**
     * 根据状态查询
     * @return
     */
    @Select("select * from user u,account a where  u.userid=a.userid")
    List<User> selectUser();


    /* @Select("select * from user "
             + "where userName like #{userName} ")
     List<User> selectUserLike(@Param("userName") String userName);*/
    @Select("SELECT * FROM USER u LEFT JOIN account a ON u.userid=a.userid WHERE u.username like #{userName}")
    List<User> selectUserLike(@Param("userName") String userName);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Delete("delete from user where userId = #{value}")
    Integer deleteUser(Integer userId);
    /*
     *//**
     * 更新状态
     *//*
    @Update("update user set userState=#{userState} where userId=#{userId}")
    int updateState(@Param("userState") Integer userState ,@Param("userId") Integer userId);*/

   /* @Update("update user set userState=#{userState} where userId=#{userId}")
    int unlockUserState(@Param("userState") Integer userState ,@Param("userId") Integer userId);*/


    /**
     * 添加用户
     */
    @Insert("insert into user(username,userage,usersex,userbirthday,useraddress,userphone,userstate) " +
            "values (" +
            "#{username},#{userage},#{usersex},#{userbirthday},#{useraddress},#{userphone},#{userstate})")
    int addUser(User user);

    /**
     * 编辑用户信息
     */
    @Update("update user set " +
            "username=#{username},userage=#{userage},usersex=#{usersex},userbirthday=#{userbirthday},useraddress=#{useraddress},userphone=#{userphone} " +
            "where userid=#{userid}")
    int editUser(User user);

    @Select("select * from user where userid=#{userid}")
    User findUserById(Integer userid);

    @Select("select * from user where " +
            "username=#{username} " +
            "and useraddress=#{useraddress}")
    User findUseridByUser(User user);
}