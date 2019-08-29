package com.restaurant.entity;

import java.io.Serializable;

/**
 * 账号实体类
 */
public class Account implements Serializable {

    private Integer accountid;

    private String accountname;

    private String accountpwd;

    private Integer role;

    private Integer userid;

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAccountpwd() {
        return accountpwd;
    }

    public void setAccountpwd(String accountpwd) {
        this.accountpwd = accountpwd == null ? null : accountpwd.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}