package com.restaurant.service;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Food;
import com.restaurant.entity.Type;

public interface IFoodService {

    /**
     * 菜品查询
     */
    PageInfo<Food> showAllFood(String foodname, Integer foodstate, Type type, Integer page, Integer pageSize);

    /**
     * 修改状态
     */
    Integer updateFoodState(Integer foodid,Integer foodstate);

    /**
     * 删除
     */
    Integer deleteFood(Integer foodid);

    /**
     * 添加
     */
    Integer addFood(String foodname,String foodpath,Integer foodstate,Type type);
}
