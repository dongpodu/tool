package com.elisonwell.tool.hutool.aop;

import com.xiaoleilu.hutool.aop.ProxyUtil;

/**
 * author duyisong
 * 2017/4/17.
 */
public class Man implements Person{

    public void say(){
        System.out.println("i am a Man!");
    }

    public static void main(String[] args){
        Person man = new Man();
        Person proxy = ProxyUtil.proxy(man,MyAspect.class);
        proxy.say();
    }

}
