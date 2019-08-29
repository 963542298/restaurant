package com.restaurant.mapper;

import com.restaurant.entity.Food;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMapper {

    /**
     * 查询所有菜品
     */
    List<Food> showAllFood();
}