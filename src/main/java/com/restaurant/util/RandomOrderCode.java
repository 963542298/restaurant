package com.restaurant.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomOrderCode {

    /**
     * 用于自动生成订单编号
     * @return
     */
    public static String getRandomOrderCode(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 用户修改订单状态自动生成
     * @return
     */
    public static String getDayCode(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }
}
