package com.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Food;
import com.restaurant.entity.FoodUtil;
import com.restaurant.entity.Orders;
import com.restaurant.entity.WrapperUtil;
import com.restaurant.mapper.DetailsMapper;
import com.restaurant.mapper.OrdersMapper;
import com.restaurant.service.IOrdersService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DetailsMapper detailsMapper;

    /**
     * 添加订单 单个
     * @return 返回影响行数
     */
    public int addOrders(Orders orders,WrapperUtil wrapperUtil) {

        //查询订单是否存在
        Integer orderid = ordersMapper.getOrdersByOrdercode(wrapperUtil.getOrderCode());
        wrapperUtil.setOrderid(orderid);

        if(!(orderid != null && orderid > 0)){//如果订单不存在，创建一个
            orders.setOrdercode(wrapperUtil.getOrderCode());
            orders.setOrderstate(1);
            orders.setOrdertime(new Date());
            int orderRowCount = ordersMapper.addOrders(orders);
            if (orderRowCount <= 0 ) {//创建失败
                return -1;
            } else { //取出订单id
                orderid = ordersMapper.getOrdersByOrdercode(orders.getOrdercode());
                wrapperUtil.setOrderid(orderid);
            }
        }

        List<Integer> foodList = wrapperUtil.getFoodList();
        List<Integer> integerList = wrapperUtil.getIntegerList();
        //创建订单详情数组
        List<FoodUtil> foodUtilList = new ArrayList<FoodUtil>();
        int num = 0;
        //接收菜品
        for (Integer integer:
                foodList) {//进行填值
            FoodUtil foodUtil = new FoodUtil();
            Food food = new Food();
            food.setFoodid(integer);
            foodUtil.setFoodid(food.getFoodid());
            foodUtil.setNum(integerList.get(num));

            foodUtilList.add(foodUtil);
            num++;
        }

        //添加订单详情
        int detailsRowCount = detailsMapper.addDetails(
                wrapperUtil.getOrderid(), foodUtilList);
        if(detailsRowCount > 0){//成功
            return 1;
        } else { //失败
            return -1;
        }
    }

    /**
     * 查询所有的订单
     * @return
     */
    public PageInfo<Orders> queryAllOrders(String ordercode, Integer page, Integer pageSize){
        PageHelper.startPage(page, pageSize);
        List<Orders> ordersList = ordersMapper.queryAllOrders(ordercode);
        PageInfo<Orders> ordersPageInfo = new PageInfo<Orders>(ordersList);
        return ordersPageInfo;
    }

    /**
     * 通过订单编号查询订单id
     * @param ordercode
     * @return
     */
    public int getOrdersByOrdercode(String ordercode){
        return ordersMapper.getOrdersByOrdercode(ordercode);
    }
}
