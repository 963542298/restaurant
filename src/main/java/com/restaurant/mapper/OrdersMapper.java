package com.restaurant.mapper;

import com.restaurant.entity.Orders;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface OrdersMapper {

    /**
     * 添加订单 单个
     * @param orders 订单
     * @return 返回影响行数
     */
    @Insert("insert into orders(ordercode,ordertime,orderstate) values(#{ordercode},#{ordertime},#{orderstate})")
    int addOrders(Orders orders);

    /**
     * 通过订单编号查询订单id
     * @param ordercode
     * @return
     */
    @Select("select orderid from orders where ordercode = #{value} ")
    Integer getOrdersByOrdercode(String ordercode);

    /**
     * 模糊查询所有的订单
     * @param ordercode
     * @return
     */
    List<Orders> queryAllOrders(@Param("ordercode") String ordercode);
}