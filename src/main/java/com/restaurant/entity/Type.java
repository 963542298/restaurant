package com.restaurant.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 菜品类型信息类
 */
public class Type implements Serializable {
    private Integer typeid;

    private String typename;

    private Integer typestate;

    private List<Food> foodList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getTypestate() {
        return typestate;
    }

    public void setTypestate(Integer typestate) {
        this.typestate = typestate;
    }
}