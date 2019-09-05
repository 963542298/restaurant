package com.restaurant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Food;
import com.restaurant.entity.Type;
import com.restaurant.mapper.FoodMapper;
import com.restaurant.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodMapper foodMapper;

    /**
     * 查询菜品
     */
    public PageInfo<Food> showAllFood(String foodname, Integer foodstate, Type type, Integer page, Integer pageSize){
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(page, pageSize);
        String foodName = foodname;
        if(foodname != null && foodname != ""){
            foodName = "%"+foodname+"%";
        }
        List<Food> foodList = foodMapper.showAllFood(foodName, foodstate, type);
        PageInfo<Food> pageList = new PageInfo<>(foodList);
        return pageList;
    }

    /**
     * 修改状态
     */
    public Integer updateFoodState(Integer foodid,Integer foodstate){
        Integer foodState = 0;
        if(foodstate == 0){
            foodState = 1;
        }
        return foodMapper.updateFoodState(foodid,foodState);
    }

    /**
     * 删除
     */
    public Integer deleteFood(Integer foodid){
        return foodMapper.deleteFood(foodid);
    }

    /**
     * 添加
     */
    public Integer addFood(String foodname,String foodpath,Integer foodstate,Type type){
        return foodMapper.addFood(foodname,foodpath,foodstate,type);
    }
    /**
     * 根据查询所有菜
     * @return
     */
    public List<Food> findFoodByTypeId(int typeId){
        return foodMapper.findFoodByTypeId(typeId);
    }

    /**
     * 菜品上下架
     * @param foodid
     * @param foodstate
     * @return
     */
    public int UpOrDownFoodState(int foodid, int foodstate) {
        return foodMapper.UpOrDownFoodState(foodid,foodstate);
    }
}
