package com.elisonwell.tool.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Locale;

/**
 * author duyisong
 * 2017/4/18.
 */
public class DateTimeTest {
    /**
     * datetime构造函数能接受很多类型的参数，如iso日期格式的字符串，java.util.Date，year-month-day.......
     */
    public static void test(){
        DateTime dateTime = new DateTime("2004-12-13T21:39:45.618-08:00");
        DateTime dateTime1 = new DateTime(100,1,12,0,0,0);
    }

    /**
     * 获取字段，有两种方式：1、类似getXXXOfYYY()，如getDayOfMonth()；2、类似XXX()，如year()；
     * 第二种方法更灵活，但也更好性能
     * Each of these also has a corresponding property method, which returns a DateTime.Property binding to the appropriate field
     */
    public static void test1(){
        DateTime dateTime = new DateTime(-100,1,1,0,0); //公元前100年，year用负数表示公元前
        System.out.println(dateTime.getYearOfEra());//0是表示公元前1年，101表示公元前100年。
        System.out.println(dateTime.getEra());
        System.out.println(dateTime.getCenturyOfEra());
        System.out.println(dateTime.getChronology());
        System.out.println(dateTime.year().getAsText(Locale.CHINA));
    }

    /**
     * 格式化输出
     */
    public static void test2(){
        //方式1：DateTimeFormat
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
        System.out.print(format.print(new DateTime()));
        //方式2：ISODateTimeFormat
        DateTimeFormatter format1 = ISODateTimeFormat.dateTime();
        System.out.print(format1.print(new DateTime()));
        //方式3：DateTimeFormatterBuilder
        DateTimeFormatter format2 = new DateTimeFormatterBuilder()
                .appendMonthOfYearText()
                .appendLiteral(' ')
                .appendYear(4, 4)
                .toFormatter();
        System.out.print(format2.print(new DateTime()));
    }

    /**
     * 解析
     */
    public static void test3(){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.print(dtf.parseDateTime("2018-01-12 10:52:21"));
    }

    /**
     * 间隔
     */
    public static void test4(){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.fromDateFields(dtf.parseDateTime("2017-04-18 10:52:21").toDate());
        System.out.println(Days.daysBetween(start,end).getDays());
    }

    public static void main(String args[]){
        test3();
    }
}
