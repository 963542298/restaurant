package com.restaurant.entity;

/**
 * 订单详情帮助类
 */
public class DetailsEmp extends Details{
    private String foodName;
    private String foodPath;

    public String getFoodPath() {
        return foodPath;
    }

    public void setFoodPath(String foodPath) {
        this.foodPath = foodPath;
    }

    private String orderCode;

    public DetailsEmp(){}

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "DetailsEmp{" +
                "foodName='" + foodName + '\'' +
                ", foodPath='" + foodPath + '\'' +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
