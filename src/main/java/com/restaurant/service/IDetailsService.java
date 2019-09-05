package com.restaurant.service;

import com.restaurant.entity.*;

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
}
