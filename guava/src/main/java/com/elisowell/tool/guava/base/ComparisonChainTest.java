package com.elisowell.tool.guava.base;


import com.google.common.collect.ComparisonChain;

/**
 * author duyisong
 * 2017/4/6.
 */
public class ComparisonChainTest {

    public static void test(){
        int result = ComparisonChain.start()
                .compare(2,2) //0 继续比较
                .compare(3,2) //3-2=1 不为0，停止比较
                .compare(1,2)//不会比较
                .result();
        System.out.println(result);
    }

    public static void main(String[] args){
        test();
    }
}
