package com.restaurant.mapper;

import com.restaurant.entity.Food;

import java.util.List;

import com.restaurant.entity.Statistics;
import com.restaurant.entity.Type;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMapper {

    /**
     * 查询所有菜品
     */
    List<Food> showAllFood(@Param("foodname") String foodname, @Param("foodstate") Integer foodstate, @Param("type") Type type);

    /**
     * 修改状态
     */
    Integer updateFoodState(@Param("foodid") Integer foodid,@Param("foodstate") Integer foodstate);

    /**
     * 删除
     */
    Integer deleteFood(Integer foodid);

    /**
     * 添加
     */
    Integer addFood(@Param("foodname") String foodname,@Param("foodpath") String foodpath,@Param("foodstate") Integer foodstate, @Param("type") Type type);

    /**
     * 根据查询所有菜
     * @return
     */
    List<Food> findFoodByTypeId(@Param("typeid") int typeid);

    /**
     * 菜品上下架
     * @param foodid
     * @param foodstate
     * @return
     */
    int UpOrDownFoodState(@Param("foodid")int foodid,@Param("foodstate")int foodstate);

    /**
     * 统计
     * @return
     */
    List<Statistics> queryFoodNum();

}