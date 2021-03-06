package com.restaurant.service;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.OrderUtil;
import com.restaurant.entity.Orders;
import com.restaurant.entity.WrapperUtil;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 订单service层接口
 */
public interface IOrdersService {

    /**
     * 添加订单 单个
     * @return 返回影响行数
     */
    int addOrders(Orders orders,WrapperUtil wrapperUtil);

    /**
     * 模糊查询订单
     * @param ordercode 订单编号
     * @param page 当前页号
     * @param pageSize 页面大小
     * @return
     */
    PageInfo<Orders> queryAllOrders(String ordercode, Integer page, Integer pageSize);

    /**
     * 通过订单编号查询订单id
     * @param ordercode
     * @return
     */
    int getOrdersByOrdercode(String ordercode);

    /**
     * 更改订单状态
     * @param orderCode
     * @return
     */
    Integer updateOrdersStateByCode(String orderCode);

    /**
     * 一段时间的订单数量
     * @return
     */
    List<OrderUtil> queryThreeDayOrder(Integer type);
}
