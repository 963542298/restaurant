package com.restaurant.service.impl;

import com.restaurant.entity.Orders;
import com.restaurant.mapper.OrdersMapper;
import com.restaurant.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 添加订单 单个
     * @param orders 订单
     * @return 返回影响行数
     */
    public int addOrders(Orders orders) {
        return ordersMapper.addOrders(orders);
    }

    /**
     * 查询所有的订单
     * @return
     */
    public List<Orders> queryAllOrders(){
        return ordersMapper.queryAllOrders();
    }
}
