package com.elisowell.tool.guava.base;


import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * author duyisong
 * 2017/4/6.
 */
public class OrderingTest {

    public static void test(){
        Ordering<Integer> ordering = Ordering.natural();
        List<Integer> list = Lists.newArrayList(10,23,12,3,12,45,56);
        System.out.println(ordering.isOrdered(list));
        System.out.println(ordering.greatestOf(list.iterator(),1));
        System.out.println(ordering.max(list.iterator()));
        System.out.println(ordering.<Integer>reverse().max(list.iterator()));
    }

    public static void test1(){
        List<Integer> list = Lists.newArrayList(2,13,45,23,56,3,12);
        Ordering<Integer> ordering1 = new Ordering<Integer>() {
            public int compare(Integer left, Integer right) {
                return Ints.compare(right, left);
            }
        };
        System.out.println(ordering1.sortedCopy(list));

    }

    public static void main(String[] args){
        test();
    }
}
