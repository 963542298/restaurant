package com.restaurant.controller;

import com.restaurant.entity.Details;
import com.restaurant.entity.DetailsEmp;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*", "null"})
@Controller
public class DetailsController {

    @Autowired
    private IDetailsService detailsService;
    private ResultUtil resultUtil = new ResultUtil();

    /**
     * 取得某个订单的数据
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
    /**
     * 查询未完成的订单详情
     * @return
     */
    @RequestMapping("/details/findAllDetails")
    public  @ResponseBody ResultUtil findAllDetails(){
        SimpleDateFormat bartDateFormat = new SimpleDateFormat
                ("yyyy-MM-dd");
        String time = bartDateFormat.format(new Date());
        List<DetailsEmp> detailsList = detailsService.findAllDetails(time);
        for (DetailsEmp details: detailsList) {
            String code =details.getOrderCode().toString().substring(0,2);
            details.setOrderCode(code);
        }
        resultUtil.reset();
        if (detailsList != null && detailsList.size() > 0) {
            resultUtil.setMessage("查询成功").setCode(0).setData(detailsList);
        } else {
            resultUtil.setMessage("查询失败").setCode(1);
        }
        return resultUtil;
    }

    /**
     * 查询所有完成了的订单详情
     * @return
     */
    @RequestMapping("/details/findFinishDetails")
    public  @ResponseBody ResultUtil findFinishDetails(){
        SimpleDateFormat bartDateFormat = new SimpleDateFormat
                ("yyyy-MM-dd");
        String time = bartDateFormat.format(new Date());
        List<DetailsEmp> detailsList = detailsService.findFinishDetails(time);
        for (DetailsEmp details: detailsList) {
            String code =details.getOrderCode().toString().substring(0,2);
            details.setOrderCode(code);
        }
        resultUtil.reset();
        if (detailsList != null && detailsList.size() > 0) {
            resultUtil.setMessage("查询成功").setCode(0).setData(detailsList);
        } else {
            resultUtil.setMessage("查询失败").setCode(1);
        }
        return resultUtil;
    }

    /**
     * 编辑订单详情完成状况
     * @param detailsId
     * @return
     */
    @RequestMapping("/details/editDetailsState")
    public  @ResponseBody ResultUtil editDetailsState(int detailsId){
        int num= detailsService.editDetailsState(detailsId);
        resultUtil.reset();
        if (num==1) {
            resultUtil.setMessage("修改成功").setCode(0);
        } else {
            resultUtil.setMessage("修改失败").setCode(1);
        }
        return resultUtil;
    }

}
