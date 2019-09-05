package com.restaurant.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomOrderCode {

    public static void main(String[] args) {
        System.out.println(getRandomOrderCode());
    }

    public static String getRandomOrderCode(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return simpleDateFormat.format(new Date());
    }
}
