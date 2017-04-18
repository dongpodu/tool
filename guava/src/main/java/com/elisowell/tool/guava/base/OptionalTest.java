package com.elisowell.tool.guava.base;

import com.google.common.base.Optional;

/**
 * optional的意义在哪：1、给了null一个专有名词 ，增加了代码的可读性  2、迫使开发人员在写代码时考虑null情况，因为你必须显式地从Optional获取引用
 * author duyisong
 * 2017/4/6.
 */
public class OptionalTest {

    public static void test(){
        Integer re = null;
        //Optional<Integer> a = Optional.of(re);//创建指定引用的Optional实例，若引用为null则快速失败
        //System.out.println(a.get());

        Optional<Integer> b = Optional.absent();//创建引用缺失的Optional实例
        System.out.println(b.isPresent());

        Optional<Integer> c = Optional.fromNullable(null);//创建指定引用的Optional实例，若引用为null则表示缺失
        System.out.println(c.isPresent());
        //System.out.println(c.get());//快速失败
        System.out.println(c.asSet());
        System.out.println(c.or(2));
        System.out.println(c.orNull());
    }

    public static void main(String[] args){
        test();
    }
}
