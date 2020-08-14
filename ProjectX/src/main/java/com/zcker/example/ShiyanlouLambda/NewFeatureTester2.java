package com.zcker.example.ShiyanlouLambda;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName NewFeatureTester2.java
 * @Description TODO
 * @createTime 2020年08月01日 09:44:00
 */

public class NewFeatureTester2 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(independenceDay);
    }
}
