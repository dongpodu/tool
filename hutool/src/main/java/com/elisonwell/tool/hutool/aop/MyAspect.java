package com.elisonwell.tool.hutool.aop;

import com.xiaoleilu.hutool.aop.aspects.SimpleAspect;
import com.xiaoleilu.hutool.date.TimeInterval;

import java.lang.reflect.Method;

/**
 * author duyisong
 * 2017/4/17.
 */
public class MyAspect extends SimpleAspect{
    public MyAspect(Object target) {
        super(target);
    }
    private TimeInterval interval = new TimeInterval();

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        interval.start();
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args) {
        System.out.println(String.format("Method [%s.%s] execute spend [%s]ms", target.getClass().getName(), method.getName(), interval.intervalMs()));
        return true;
    }
}
