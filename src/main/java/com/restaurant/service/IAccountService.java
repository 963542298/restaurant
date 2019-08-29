package com.restaurant.service;

import com.restaurant.entity.Account;
import org.apache.ibatis.annotations.Insert;


public interface IAccountService {

    Account login(String accountName, String accountPwd);

    Integer insert(String accountname, String accountpwd, Integer role, Integer userID);

    Integer update(Integer userID, String accountpwd);
}
