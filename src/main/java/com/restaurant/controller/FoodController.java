package com.restaurant.controller;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Food;
import com.restaurant.entity.ResultUtil;
import com.restaurant.entity.Type;
import com.restaurant.service.IFoodService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static com.restaurant.util.RandomName.getRandomName;

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
    public @ResponseBody PageInfo<Food> showAllFood(Model model, HttpServletRequest request, Integer page, Integer pageSize){
        String foodName = request.getParameter("foodName");
        String foodState = request.getParameter("foodState");
        String typeId = request.getParameter("foodType");
        Integer foodstate = -1;
        Integer typeid = -1;
        if(foodState != null && foodState != ""){
            foodstate = Integer.parseInt(foodState);
        }
        if(typeId != null && typeId !=""){
            typeid = Integer.parseInt(typeId);
        }
        Type type = new Type();
        type.setTypeid(typeid);

        PageInfo<Food> pageList = foodService.showAllFood(foodName,foodstate,type,page,pageSize);
        return pageList;
    }

    /**
     * 修改状态
     */
    @RequestMapping("/food/updateFoodState")
    public @ResponseBody ResultUtil updateFoodState(HttpServletRequest request){
        String foodId = request.getParameter("foodId");
        String foodState = request.getParameter("foodState");
        Integer foodid = -1;
        Integer foodstate = -1;
        if(foodId != null){
            foodid = Integer.parseInt(foodId);
        }
        if(foodState != null){
            foodstate = Integer.parseInt(foodState);
        }
        Integer count = foodService.updateFoodState(foodid,foodstate);
        if(count > 0){
            resultUtil.reset();
            resultUtil.setCode(0).setMessage("修改成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("修改失败");
        }
        return resultUtil;
    }

    /**
     * 删除
     */
    @RequestMapping("/food/deleteFood")
    public @ResponseBody ResultUtil deleteFood(HttpServletRequest request){
        String foodId = request.getParameter("foodId");
        Integer foodid = -1;
        if(foodId != null){
            foodid = Integer.parseInt(foodId);
        }
        int count = foodService.deleteFood(foodid);
        if(count > 0){
            resultUtil.reset();
            resultUtil.setCode(0).setMessage("删除成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("删除失败");
        }
        return resultUtil;
    }

    /**
     * 添加
     */
    @RequestMapping("/food/addFood")
    public @ResponseBody ResultUtil addFood(MultipartFile file,HttpServletRequest request){

        String foodName = request.getParameter("foodName");
        String foodState = request.getParameter("foodState");
        String typeId = request.getParameter("foodType");
        String foodPath = uploadImage(file,request);
        Integer foodstate = -1;
        Integer typeid = -1;
        if(foodState != null && foodState != ""){
            foodstate = Integer.parseInt(foodState);
        }
        if(typeId != null && typeId !=""){
            typeid = Integer.parseInt(typeId);
        }
        Type type = new Type();
        type.setTypeid(typeid);

        int count = foodService.addFood(foodName,foodPath,foodstate,type);
        if(count > 0){
            resultUtil.reset();
            resultUtil.setCode(0).setMessage("添加成功");
        } else {
            resultUtil.reset();
            resultUtil.setCode(1).setMessage("添加失败");
        }
        return resultUtil;
    }

    /**
     * 上传图片
     */
   public @ResponseBody String uploadImage(MultipartFile file, HttpServletRequest request){

        //取得文件名 d:\afas\sdfs\xxx.jpg
        String name = file.getOriginalFilename();
        //截取字符串 最后面的文件名
        String realFileName = name.substring(name.lastIndexOf(File.separatorChar) + 1);

        // 存储文件夹名  存储文件名
        HashMap<String,Object> map = getRandomName(realFileName);

        //获取服务器的真实路径 E:\IDEA\ssm\src\main\webapp
        String realPath = request.getServletContext().getRealPath("");

        //取得文件夹名
        String dir = (String)map.get("dir");

        //判断文件存储的路径是否存在
        File dirFile = new File(realPath + "/" + dir);
        //如果这个目录还不存在，就先创建一个
        if(dirFile.exists()){
            dirFile.mkdirs();
        }

        //文件上传真实路径
        String realPathName = realPath + "/" + dir + "/" + map.get("fileName");
        //上传文件
        File uploadFile = new File(realPathName);
        System.out.println(realPathName);
        try {
            //
            file.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realPathName;
    }
}
