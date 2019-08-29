package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.*;
import com.restaurant.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.restaurant.util.ConfigUtils.*;

/**
 *
 */
//@CrossOrigin(origins = {"/*", "null"})
@Controller
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 添加订单
     * @return
     */
    @RequestMapping("/orders/addOrders")
    public @ResponseBody
    ResultUtil addOrders(@RequestBody List<Integer> foodList,@RequestBody List<Integer> integerList){
//        WrapperUtil wrapperUtil = new WrapperUtil();
//        String food = request.getParameter("foodList");
//        String integer = request.getParameter("integerList");
//        System.out.println(wrapperUtil.getFoodList().toString());
//        System.out.println(wrapperUtil.getIntegerList().toString());
//        //取得菜品数组
//        List<Integer> foodList = wrapperUtil.getFoodList();
//        //取得菜品数量
//        List<Integer> integerList = wrapperUtil.getIntegerList();
        //创建订单详情数组
        List<Details> detailsList = new ArrayList<Details>();

        int num = 0;
        //接收菜品
        for (Integer integer:
             foodList) {//进行填值
            Details details = new Details();
            Food food = new Food();
            food.setFoodid(integer);

            details.setFood(food);
            details.setNum(integerList.get(num));

            detailsList.add(details);
            num++;
        }
        Orders orders = new Orders();
        orders.setDetailsList(detailsList);

        WrapperUtil wrapperUtil = new WrapperUtil();
        wrapperUtil.setFoodList(foodList);
        wrapperUtil.setIntegerList(integerList);
        wrapperUtil.setOrderCode("202019082819");

        int rowCount = ordersService.addOrders(orders,wrapperUtil);
        if(rowCount > 0){
            resultUtil.setCode(0).setMessage("添加成功");
        } else{
            resultUtil.setMessage("添加失败").setCode(1);
        }
        return resultUtil;
    }

    /**
     * 查询订单
     * @param model
     * @param wrapperUtil
     * @return
     */
    @RequestMapping("/orders/queryAll")
    public @ResponseBody ResultUtil queryAllOrders(Model model,WrapperUtil wrapperUtil){
        if(wrapperUtil.getOrderCode() == ""){
            wrapperUtil.setOrderCode(null);
        } else {
            String ordercode = wrapperUtil.getOrderCode();
            ordercode = "%"+ordercode+"%";
            wrapperUtil.setOrderCode(ordercode);
        }
        if(wrapperUtil.getPage() == null){
            wrapperUtil.setPage(1);
        }
        PageInfo<Orders> ordersPageInfo = ordersService.queryAllOrders(wrapperUtil.getOrderCode(),wrapperUtil.getPage(),getIntValue("pageSize"));
        if(ordersPageInfo != null ){
            resultUtil.reset();
            resultUtil.setData(ordersPageInfo).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("查询失败");
        }
        model.addAttribute("resultUtil",resultUtil);
        return resultUtil;
    }
}
