package com.gupaoedu.vip.design.principle.liskovsubstitution.methodparam;

import java.util.Map;

/**
 * Created by Tom
 */
public class Child extends Base {
//    @Override
//    public void method(HashMap map) {
//        System.out.println("子类HashMap入参方法被执行");
//    }

    public void method(Map map) {
        System.out.println("子类HashMap入参方法被执行");
    }
}
