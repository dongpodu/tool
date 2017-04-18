package com.elisowell.tool.guava.collection;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.Iterator;

/**
 * author duyisong
 * 2017/4/6.
 */
public class TreeMultisetTest {

    /**
     */
    public static void test(){
        Multiset<Integer> set = TreeMultiset.create();
        set.add(5);
        set.add(5);
        set.add(9);
        set.add(9);
        set.add(9);
        System.out.println(set); //[5 x 2, 9 x 3]  2个5 ，3个9
        System.out.println(set.count(5));//5的个数：2
        System.out.println(set.elementSet());//[5, 9]
        System.out.println(set.entrySet());//[5 x 2, 9 x 3]
        System.out.println(set.size());//5
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void test1(){
    }


    public static void main(String[] args){
        test();
    }

}
