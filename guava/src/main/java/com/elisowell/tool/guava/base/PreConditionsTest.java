package com.elisowell.tool.guava.base;


import static com.google.common.base.Preconditions.checkArgument;

/**
 * Each method has three variants:
 * 1、No extra arguments. Any exceptions are thrown without error messages.
 * 2、An extra Object argument. Any exception is thrown with the error message object.toString().
 * 3、An extra String argument, with an arbitrary number of additional Object arguments.
 * This behaves something like printf, but for GWT compatibility and efficiency, it only allows %s indicators.
 * author duyisong
 * 2017/4/6.
 */
public class PreConditionsTest {

    public static void test(){
        Object obj = null;
        //checkNotNull(obj);
        //checkNotNull(obj,"不能为null");
        checkArgument(1>2,"pre:%s,post:%s",1,2);
    }

    public static void main(String[] args){
        test();
    }
}
