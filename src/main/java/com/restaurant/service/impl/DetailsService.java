package com.restaurant.service.impl;

import com.restaurant.entity.Details;
import com.restaurant.entity.Food;
import com.restaurant.entity.FoodUtil;
import com.restaurant.entity.WrapperUtil;
import com.restaurant.mapper.DetailsMapper;
import com.restaurant.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.resources.da.FormatData_da;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailsService implements IDetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public List<Details> queryDetailsByOrdersId(Integer ordersid) {
        return detailsMapper.queryDetailsByOrdersId(ordersid);
    }

    /**
     * 插入订单详情
     * @param wrapperUtil
     * @return
     */
    public int addDetails(WrapperUtil wrapperUtil){
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
        return detailsMapper.addDetails(
                wrapperUtil.getOrderid(), foodUtilList);
    }
}
