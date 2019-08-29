package com.restaurant.entity;

import java.io.Serializable;

/**
 * 菜品类
 */
public class Food implements Serializable {

    //菜品id
    private Integer foodid;
    //菜品名
    private String foodname;
    //菜品图片路径
    private String foodpath;
    //菜品类型
    private Type type;
    //菜品状态
    private Integer foodstate;

    public Food() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getFoodpath() {
        return foodpath;
    }

    public void setFoodpath(String foodpath) {
        this.foodpath = foodpath == null ? null : foodpath.trim();
    }

    public Integer getFoodstate() {
        return foodstate;
    }

    public void setFoodstate(Integer foodstate) {
        this.foodstate = foodstate;
    }
}