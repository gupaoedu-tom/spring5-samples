package com.gupaoedu.vip.spring.formework.aop;

import com.gupaoedu.vip.spring.formework.aop.support.GPAdvisedSupport;

/**
 * Created by Tom on 2019/4/14.
 */
public class GPCglibAopProxy implements  GPAopProxy {
    public GPCglibAopProxy(GPAdvisedSupport config) {
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
