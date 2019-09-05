package com.restaurant.service;

import com.restaurant.entity.Type;

import java.util.List;

public interface ITypeService {

    /**
     * 查询所有菜品类型
     */
    List<Type> showAllType();

    /**
     * 添加菜品类型
     */
    Integer addType(String typename);

    /**
     *查询所有菜品名称
     * @return
     */
    List<Type> findAllTypeName();

    /**
     * 菜品类型里面有点菜品
     * @return
     */
    List<Type> findTypeAndFood();
}
