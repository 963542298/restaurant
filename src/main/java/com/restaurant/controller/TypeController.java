package com.restaurant.controller;

import com.restaurant.entity.ResultUtil;
import com.restaurant.entity.Type;
import com.restaurant.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 查询所有菜品类型
     */
    @RequestMapping("/type/showAllType")
    public @ResponseBody ResultUtil showAllType(Model model){
        List<Type> typeList = typeService.showAllType();
        if (typeList != null && typeList.size() > 0){
            resultUtil.reset();
            resultUtil.setData(typeList).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("查询失败");
        }
        model.addAttribute("resultUtil",resultUtil);
        return resultUtil;
    }

    /**
     * 添加菜品类型
     */
    @RequestMapping("/type/addType")
    public @ResponseBody ResultUtil addType(String typename){
        Integer count = typeService.addType(typename);
        if(count > 0){
            resultUtil.reset();
            resultUtil.setCode(0).setMessage("添加成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("添加失败");
        }
        return resultUtil;
    }
}
