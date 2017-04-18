package com.elisowell.tool.guava.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * author duyisong
 * 2017/4/7.
 */
public class StringTest {

    public static void test(){
        Joiner joiner = Joiner.on("#").skipNulls();
        String result = joiner.join(1,3,4,5,2,null);
        System.out.println(result);

        Joiner joiner1 = Joiner.on(":").skipNulls();
        System.out.println(joiner1.join(Arrays.asList(2,3,5,1,7)));
        System.out.println(joiner1.appendTo(new StringBuilder("com/elisowell/tool/guava"), Lists.newArrayList("google","baidu")));
    }

    public static void test1(){
        StringJoiner joiner = new StringJoiner("#");
        String result = joiner.add("1").add("2").add("3").toString();
        System.out.println(result);
    }

    public static void test2(){
        String str = ",a,,b,";
        System.out.println(str.split(",").length);//本来分解后的结果是:"", "a", "", "b", "",但尾部的""会被去掉
        System.out.println(Splitter.on(',')
                //.trimResults()
                //.omitEmptyStrings()
                .splitToList(str).size());
        System.out.println(Splitter.on(',')
                .limit(4)
                .splitToList("a,b#c,d,e#f#g&h"));
    }

    public static void test3(){
        String str = "dave:123,john:314,matt:989";
        System.out.println(Splitter.on(',')
                .withKeyValueSeparator(":") //把str分解为map对象
                .split(str));
    }

    public static void main(String[] args){
        test3();
    }
}
