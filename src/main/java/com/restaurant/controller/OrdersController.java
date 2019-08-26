package com.restaurant.controller;

import com.restaurant.entity.Details;
import com.restaurant.entity.Food;
import com.restaurant.entity.Orders;
import com.restaurant.entity.ResultUtil;
import com.restaurant.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 添加订单
     * @return
     */
    @RequestMapping("/")
    public @ResponseBody
    ResultUtil addOrders(HttpServletRequest request, List<Food> foodList){
        Orders orders = new Orders();
        Details details = new Details();
        //接收菜品
        for (Food food:
             foodList) {
            details.setFood(food);

        }


        int rowCount = ordersService.addOrders(orders);
        if(rowCount > 0){
            resultUtil.setCode(0).setMessage("添加成功");
        } else{
            resultUtil.setMessage("添加失败").setCode(1);
        }
        return resultUtil;
    }

    @RequestMapping("/orders/queryAll")
    public ResultUtil queryAllOrders(){
        List<Orders> ordersList = ordersService.queryAllOrders();
        if(ordersList != null && ordersList.size() > 0){
            resultUtil.setData(ordersList).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.setCode(1).setMessage("查询失败");
        }
        return resultUtil;

    }
}
