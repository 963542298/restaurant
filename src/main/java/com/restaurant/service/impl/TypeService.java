package com.restaurant.service.impl;

import com.restaurant.entity.Food;
import com.restaurant.entity.Type;
import com.restaurant.mapper.TypeMapper;
import com.restaurant.service.ITypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询所有菜品类型
     */
    public List<Type> showAllType(){
        List<Type> typeList = typeMapper.showAllType();
        return typeList;
    }

    /**
     * 添加菜品类型
     */
    public Integer addType(String typename){
        return typeMapper.addType(typename);
    }

    /**
     * 查询所有菜品名称
     * @return
     */
    public List<Type> findAllTypeName() {
        return typeMapper.findAllTypeName();
    }

    /**
     * 菜品类型里面有点菜品
     * @return
     */
    public List<Type> findTypeAndFood(){
        return  typeMapper.findTypeAndFood();
    }
}
