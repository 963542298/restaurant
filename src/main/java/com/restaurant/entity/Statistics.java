package com.restaurant.entity;

/**
 * 统计帮助类
 */
public class Statistics {

    private String foodname;
    private Integer num;

    public Statistics() {
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
