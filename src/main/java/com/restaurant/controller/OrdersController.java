package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.*;
import com.restaurant.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.restaurant.util.ConfigUtils.*;
import static com.restaurant.util.RandomOrderCode.*;

/**
 *
 */
@CrossOrigin(origins = {"*", "null"})
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
    ResultUtil addOrders(String foodList,String integerList,String id){

        String[] foods = foodList.split(",");
        String[] integers = integerList.split(",");

        List<Integer> foodList1 = new ArrayList<Integer>();
        List<Integer> integerList1 = new ArrayList<Integer>();
        for (String str:
             foods) {
            foodList1.add(Integer.parseInt(str));
        }
        for (String str:
             integers) {
            integerList1.add(Integer.parseInt(str));
        }

        //创建订单详情数组
        List<Details> detailsList = new ArrayList<Details>();
        int num = 0;
        //接收菜品
        for (Integer integer1:
             foodList1) {//进行填值
            Details details = new Details();
            Food food1 = new Food();
            food1.setFoodid(integer1);

            details.setFood(food1);
            details.setNum(integerList1.get(num));

            detailsList.add(details);
            num++;
        }
        Orders orders = new Orders();
        orders.setDetailsList(detailsList);

        WrapperUtil wrapperUtil = new WrapperUtil();
        wrapperUtil.setFoodList(foodList1);
        wrapperUtil.setIntegerList(integerList1);
        String orderCode = id+getRandomOrderCode();
        wrapperUtil.setOrderCode(orderCode);

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

    /**
     * 修改订单状态
     * @param tableCode
     * @return
     */
    @RequestMapping("orders/updateOrder")
    public @ResponseBody ResultUtil updateOrderByOrderCode(String tableCode){
        resultUtil.reset();
        String orderCode = tableCode+getDayCode();

        Integer rowCount = ordersService.updateOrdersStateByCode(orderCode);
        if(rowCount > 0){
            resultUtil.setCode(0).setMessage("修改成功");
        } else {
            resultUtil.setCode(1).setMessage("修改失败");
        }

        return resultUtil;
    }
}
