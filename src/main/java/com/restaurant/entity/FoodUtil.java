package com.restaurant.entity;

import java.io.Serializable;

/**
 * 食物帮助类
 */
public class FoodUtil implements Serializable {

    private Integer foodid;
    private Integer num;

    public FoodUtil() {
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
