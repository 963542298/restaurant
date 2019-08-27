package com.restaurant.service;

import com.restaurant.entity.Food;

import java.util.List;

public interface IFoodService {

    /**
     * 查询所有菜品
     */
    List<Food> showAllFood();
}
