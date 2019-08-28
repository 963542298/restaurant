package com.restaurant.controller;

import com.restaurant.entity.Details;
import com.restaurant.entity.Food;
import com.restaurant.entity.ResultUtil;
import com.restaurant.service.IDetailsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@CrossOrigin(origins = {"/*", "null"})
@Controller
public class DetailsController {

    @Autowired
    private IDetailsService detailsService;
    private ResultUtil resultUtil = new ResultUtil();

    /**
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/details/queryAllDetails")
    public @ResponseBody ResultUtil queryDetailsByOrdersId(HttpServletRequest request){
        List<Details> detailsList = detailsService.queryDetailsByOrdersId(Integer.parseInt(request.getParameter("ordersid")));
        resultUtil.reset();
        if (detailsList != null && detailsList.size() > 0) {
          resultUtil.setMessage("查询成功").setCode(0).setData(detailsList);
        } else {
            resultUtil.setMessage("查询失败").setCode(1);
        }
        return resultUtil;
    }

}
