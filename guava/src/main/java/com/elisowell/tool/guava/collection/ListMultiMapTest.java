package com.elisowell.tool.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * author duyisong
 * 2017/4/6.
 */
public class ListMultiMapTest {

    /**
     */
    public static void test(){
        ListMultimap<Integer,String> map = ArrayListMultimap.create();
        map.put(1,"a");
        map.put(1,"b");
        map.put(1,"c");
        map.put(2,"d");
        map.put(2,"e");
        map.put(2,null);
        map.put(3,null);
        System.out.println(map); //
        System.out.println(map.get(1));//
        System.out.println(map.containsKey(3));//
        System.out.println(map.get(3));//[null]
        System.out.println(map.get(3).size());//1
    }

    public static void test1(){
    }


    public static void main(String[] args){
        test();
    }

}
