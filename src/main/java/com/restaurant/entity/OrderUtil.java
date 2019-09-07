package com.restaurant.entity;

/**
 * 订单帮助类
 */
public class OrderUtil {

    private Orders orders;
    private Integer count;

    public OrderUtil() {
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
