package com.restaurant.mapper;

import com.restaurant.entity.Account;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface AccountMapper {

    //根据用户名和密码查询用户
    @Select("select accountid,accountname,accountpwd from account where accountname=#{0} and accountpwd = #{1}")
    Account login(String accountname, String accountpwd);

    //注册账号
    @Insert("insert into account(accountName,accountPwd,role,userId) values( #{accountname},#{accountpwd},#{role},#{userid}) ")
    Integer insert(@Param("accountname") String accountName,@Param("accountpwd") String accountPwd,@Param("role") Integer role, @Param("userid") Integer userid);

    //修改密码
    @Update("update account set accountPwd=? where userId=?")
    Integer update(int userID,String accountPwd);

    //通过名字查询账号
    @Select("select accountid,accountname,accountpwd from account where accountname=#{0}")
    Account getAccount(String accountname);

    //通过名字查询role
    @Select("select role from account where accountname=#{0}")
    Integer getRole(String accountname);

    //删除账号
    @Delete("delete from account where userid=#{userid}")
    Integer delete(@Param("userid") Integer userid);
}