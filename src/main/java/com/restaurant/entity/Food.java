package com.restaurant.entity;

/**
 * 菜品类
 */
public class Food {
    private Integer foodid;

    private String foodname;

    private String foodpath;

    private Integer typeid;

    private Integer foodstate;

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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getFoodstate() {
        return foodstate;
    }

    public void setFoodstate(Integer foodstate) {
        this.foodstate = foodstate;
    }
}