package com.restaurant.service;

import com.restaurant.entity.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 添加订单 单个
     * @param orders 订单
     * @return 返回影响行数
     */
    int addOrders(Orders orders);

    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> queryAllOrders();
}
