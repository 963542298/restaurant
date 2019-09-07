package com.restaurant.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 */
public class DateUtil {

    public static List<String> pastDay(Integer type){
        String pastDay = null;
        String nowDay = null;
        List<String> stringList = new ArrayList<String>(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        if(type == 1){//这是最近三天的
            stringList.clear();
            c.setTime(new Date());
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-2);
            pastDay = simpleDateFormat.format(c.getTime());
            nowDay = simpleDateFormat.format(new Date());
            stringList.add(pastDay);
            stringList.add(nowDay);
        } else if(type == 2 ){//这是最近一个月的
            stringList.clear();
            c.setTime(new Date());
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-30);
            pastDay=simpleDateFormat.format(c.getTime());
            nowDay = simpleDateFormat.format(new Date());
            stringList.add(pastDay);
            stringList.add(nowDay);
        } else if (type == 3){//这是一年的
            stringList.clear();
            c.setTime(new Date());
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day-365);
            pastDay=simpleDateFormat.format(c.getTime());
            nowDay = simpleDateFormat.format(new Date());
            stringList.add(pastDay);
            stringList.add(nowDay);
        }
        return stringList;
    }



    public static void main(String[] args) {
        System.out.println(pastDay(3));
    }
}
