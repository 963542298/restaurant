package com.restaurant.service.impl;

import com.restaurant.mapper.AccountMapper;
import com.restaurant.service.IAccountService;


import com.restaurant.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.restaurant.util.MD5Util.*;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper AccountMapper;

    @Override
    public Account login(String accountName, String accountPwd) {
        String pwd = encrypt(accountPwd);
        return AccountMapper.login(accountName,pwd);
    }

    public Integer insert(String accountname, String accountpwd ,Integer role,Integer userID) {
        return AccountMapper.insert(accountname,accountpwd,role,userID);
    }

    public Integer update(Integer userID, String accountpwd) {
        return AccountMapper.update(userID,accountpwd);
    }

}
