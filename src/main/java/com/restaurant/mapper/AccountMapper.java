package com.restaurant.mapper;

import com.restaurant.entity.Account;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    //根据用户名和密码查询用户
    @Select("select accountid,accountname,accountpwd from account where accountname=#{0} and accountpwd = #{1}")
    Account login(String accountname, String accountpwd);

    //注册账号
    @Insert("insert into account (accountName,accountPwd,role,userId) values(#{0},#{1},#{2},#{3} ")
    Integer insert(String accountName,String accountPwd,Integer role,Integer userID);

    //修改密码
    @Update("update account set accountPwd=? where userId=?")
    Integer update(int userID,String accountPwd);
}