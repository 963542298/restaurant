package com.restaurant.mapper;

import com.restaurant.entity.Details;

import java.util.List;

import com.restaurant.entity.DetailsEmp;
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
            @Param("orderid") int orderid, @Param("foodUtilList")List<FoodUtil> foodUtilList);
    /**
     * 查询所有订单
     * @return
     */
    List<DetailsEmp> findAllDetails(String time);


    /**
     * 查询今日完成了的订单
     * @return
     */
    List<DetailsEmp> findFinishDetails(String time);

    /**
     * 修改详情状态
     * @param detailsId
     */
    int editDetailsState(int detailsId);

    /**
     *
     * @param orderCode
     * @return
     */
    Integer deleteDetailsByOrderCode(String orderCode);

}