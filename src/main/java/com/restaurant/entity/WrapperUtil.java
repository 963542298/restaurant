package com.restaurant.entity;

import java.util.List;

/**
 *
 */
public class WrapperUtil {

    // 菜品数组
    private List<Food> foodList;

    public WrapperUtil() {
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
