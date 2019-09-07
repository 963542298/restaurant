package com.restaurant.controller;

import com.restaurant.entity.ResultUtil;
import com.restaurant.entity.Type;
import com.restaurant.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = {"*", "null"})
@Controller
/**
 * 菜品类型控制器
 */
public class TypeController {

    @Autowired
    private ITypeService typeService;

    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 查询所有菜品类型
     */
    @RequestMapping("/type/showAllType")
    public @ResponseBody ResultUtil showAllType(Model model){
        resultUtil.reset();
        List<Type> typeList = typeService.showAllType();
        if (typeList != null && typeList.size() > 0){
            resultUtil.setData(typeList).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.setCode(1).setMessage("查询失败");
        }
        model.addAttribute("resultUtil",resultUtil);
        return resultUtil;
    }

    /**
     * 添加菜品类型
     */
    @RequestMapping("/type/addType")
    public @ResponseBody ResultUtil addType(HttpServletRequest request){
        resultUtil.reset();
        String typeName = request.getParameter("typeName");
        Integer count = typeService.addType(typeName);
        if(count > 0){
            resultUtil.setCode(0).setMessage("添加成功");
        } else {
            resultUtil.setCode(1).setMessage("添加失败");
        }
        return resultUtil;
    }

    //=======================================================================

    /**
     * 取得菜品类型名
     * @return
     */
    @RequestMapping("/type/findAllTypeName")
    public @ResponseBody
    ResultUtil findAllTypeName(){
        resultUtil.reset();
        List<Type> typeList = typeService.findAllTypeName();
        if (typeList != null && typeList.size() > 0){
            resultUtil.reset();
            resultUtil.setData(typeList).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("查询失败");
        }
        return resultUtil;
    }

    /**
     * 菜品类型里面有点菜品
     * @return
     */
    @RequestMapping("type/typeAndFood")
    public @ResponseBody ResultUtil findTypeAndFood(){
        resultUtil.reset();
        List<Type> typeList = typeService.findTypeAndFood();
        if(typeList != null && typeList.size() > 0){
            resultUtil.setMessage("查询成功").setCode(0).setData(typeList);
        } else {
            resultUtil.setCode(1).setMessage("查询失败");
        }
        return resultUtil;

    }
}
