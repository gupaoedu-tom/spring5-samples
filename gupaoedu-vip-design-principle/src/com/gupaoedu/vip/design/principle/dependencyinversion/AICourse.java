package com.gupaoedu.vip.design.principle.dependencyinversion;

/**
 * Created by Tom
 */
public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom在学习AI课程");
    }

}
