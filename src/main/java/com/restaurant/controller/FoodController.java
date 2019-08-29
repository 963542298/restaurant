package com.restaurant.controller;

import com.restaurant.entity.Food;
import com.restaurant.entity.ResultUtil;
import com.restaurant.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@CrossOrigin(origins = {"/*", "null"})
@Controller
public class FoodController {

    @Autowired
    private IFoodService foodService;

    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 查询所有菜品
     */
    @RequestMapping("/food/showAllFood")
    public @ResponseBody ResultUtil showAllFood(Model model){
        List<Food> foodList = foodService.showAllFood();
        if (foodList != null && foodList.size() > 0){
            resultUtil.reset();
            resultUtil.setData(foodList).setCode(0).setMessage("查询成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("查询失败");
        }
        model.addAttribute("resultUtil",resultUtil);
        return resultUtil;
    }
}
