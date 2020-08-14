package com.zcker.example.easyJDK.lang;

import java.util.Date;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example7.java
 * @Description TODO
 * @createTime 2020年08月03日 10:11:00
 */

public class Example7 {
    public static void main(String[] args) throws ClassNotFoundException {
        String strDate, strTime = "";
        Date objDate = new Date();
        System.out.println("今天的日期是：" + objDate);
        long time = objDate.getTime();
        System.out.println("自 1970 年 1 月 1 日起以毫秒为单位的时间（GMT）：" + time);
        strDate = objDate.toString();
        //提取 GMT 时间
        strTime = strDate.substring(11,(strDate.length() - 4));
        //按小时、分钟和秒提取时间
        strTime = "时间：" + strTime.substring(0,8);
        System.out.println(strTime);
    }
}
