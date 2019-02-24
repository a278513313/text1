package com.itheima.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //时间格式
    public  static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /***
     * 时间格式转换
     * @param date
     * @return
     */
    public static String dateToStr(Date date){
        return simpleDateFormat.format(date);
    }
}
