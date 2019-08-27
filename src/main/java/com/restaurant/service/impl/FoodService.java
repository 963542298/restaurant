package com.restaurant.service.impl;

import com.restaurant.entity.Food;
import com.restaurant.mapper.FoodMapper;
import com.restaurant.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodMapper foodMapper;
    /**
     * 查询所有菜品
     */
    public List<Food> showAllFood(){
        return foodMapper.showAllFood();
    }
}
