package com.restaurant.mapper;

import com.restaurant.entity.Orders;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 *
 */
public interface OrdersMapper {

    /**
     * 添加订单 单个
     * @param orders 订单
     * @return 返回影响行数
     */
    @Insert("")
    int addOrders(Orders orders);

    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> queryAllOrders();
}