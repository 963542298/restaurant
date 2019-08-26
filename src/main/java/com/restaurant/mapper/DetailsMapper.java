package com.restaurant.mapper;

import com.restaurant.entity.Details;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailsMapper {

    /**
     * 查询单个订单的订单详情
     * @param ordersId
     * @return
     */
    List<Details> queryDetailsByOrdersId(Integer ordersId);
}