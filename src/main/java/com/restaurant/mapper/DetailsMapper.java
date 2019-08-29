package com.restaurant.mapper;

import com.restaurant.entity.Details;

import java.util.List;

import com.restaurant.entity.Food;
import com.restaurant.entity.FoodUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface DetailsMapper {

    /**
     * 查询单个订单的订单详情
     * @param ordersId
     * @return
     */
    List<Details> queryDetailsByOrdersId(Integer ordersId);

    /**
     * 插入订单详情
     * @param foodUtilList
     * @return
     */
    int addDetails(
            @Param("orderid") int orderid, @Param("foodList")List<FoodUtil> foodUtilList);
}