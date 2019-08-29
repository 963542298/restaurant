package com.restaurant.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 产生随机名
 */
public class RandomName {

    public static HashMap<String,Object> getRandomName(String realFileName){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();

        //创建需要存储文件的文件夹的名字
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());

        //文件名
        String fileName = date+realFileName;

        hashMap.put("dir","images");
        hashMap.put("fileName",fileName);

        return hashMap;
    }
}
