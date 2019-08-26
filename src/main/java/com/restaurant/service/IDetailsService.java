package com.restaurant.service;

import com.restaurant.entity.Orders;

import java.util.List;

/**
 * 订单详情服务层接口
 */
public interface IDetailsService {

    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> queryAllOrders();
}
