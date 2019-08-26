package com.restaurant.entity;

/**
 * 订单详情类
 */
public class Details {

    //订单详情id
    private Integer detailsid;
    //菜品类
    private Food food;
    //数量
    private Integer num;

    /**
     * 无参构造方法
     */
    public Details() {
    }

    public Integer getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(Integer detailsid) {
        this.detailsid = detailsid;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}