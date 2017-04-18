package com.elisowell.tool.guava.collection;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * 不可变set
 * 1、不能包含null
 * 2、
 * author duyisong
 * 2017/4/6.
 */
public class ImmutableSetTest {

    /**
     * An ImmutableXXX collection can be created in several ways:
     */
    public static void test(){
        //way 1
        Set<Integer> set = Sets.newHashSet(1,2,3);
        ImmutableSet immutableSet = ImmutableSet.copyOf(set);
        set.add(4);
        System.out.println(immutableSet);

        //way 2
        ImmutableSortedSet immutableSet1 = ImmutableSortedSet.of(1,2,3,5,4,2,8);
        //System.out.println(immutableSet1);
        Iterator<Integer> it=immutableSet1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //way 3
        ImmutableSet immutableSet2 = ImmutableSet
                .builder()
                .add(1,2,3)
                .addAll(set)
                .build();
        //System.out.println(immutableSet2);

    }

    /**
     * jdk的Collections类中的某些方法可以使得集合不可变，但我们仍然可以通过改变原有的集合来改变他
     */
    public static void test1(){
        Set<Integer> set = Sets.newHashSet(1,2,3);
        Set<Integer> set1 = Collections.unmodifiableSet(set);
        //set1.add(4);//报错
        set.add(4);
        System.out.print(set);
        System.out.print(set1);//set1跟着set改变
    }


    public static void main(String[] args){
        test();
    }

}
