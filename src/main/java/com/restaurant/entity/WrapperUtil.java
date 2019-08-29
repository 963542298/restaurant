package com.restaurant.entity;


import java.util.List;

/**
 *
 */
public class WrapperUtil {

    //订单id
    private Integer orderid;
    // 菜品数组            foodList
    private List<Integer> foodList;
    // 菜品数量            integerList
    private List<Integer> integerList;
    //订单编码
    private String orderCode;
    //页码
    private Integer page;

    public WrapperUtil() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Integer> foodList) {
        this.foodList = foodList;
    }
}
