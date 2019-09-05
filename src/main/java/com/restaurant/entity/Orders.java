package com.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
public class Orders implements Serializable {

    //订单id
    private Integer orderid;
    //订单编号
    private String ordercode;
    //订单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ordertime;
    //订单状态
    private Integer orderstate;
    //订单详情类
    private List<Details> detailsList;

    /**
     * 无参构造方法
     */
    public Orders() {
    }

    public List<Details> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<Details> detailsList) {
        this.detailsList = detailsList;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
}