package com.restaurant.service;

import com.restaurant.entity.Details;
import com.restaurant.entity.Food;
import com.restaurant.entity.Orders;
import com.restaurant.entity.WrapperUtil;

import java.util.List;

/**
 * 订单详情服务层接口
 */
public interface IDetailsService {

    /**
     * 查询所有的订单
     * @return
     */
    List<Details> queryDetailsByOrdersId(Integer ordersid);

    /**
     * 插入订单详情
     * @param wrapperUtil
     * @return
     */
    int addDetails(WrapperUtil wrapperUtil);
}
