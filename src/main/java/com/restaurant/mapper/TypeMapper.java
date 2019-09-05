package com.restaurant.mapper;

import com.restaurant.entity.Type;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {

    /**
     * 查询所有菜品类型
     */
    List<Type> showAllType();

    /**
     * 添加菜品类型
     */
    Integer addType(String typename);

    /**
     *查询所有菜品种类名字
     * @return
     */
    List<Type> findAllTypeName();

    /**
     * 菜品类型里面有点菜品
     * @return
     */
    List<Type> findTypeAndFood();
}