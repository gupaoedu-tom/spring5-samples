package com.gupaoedu.vip.pattern.factory.abstractfactory;

/**
 * Created by Tom.
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        JavaCourseFactory factory = new JavaCourseFactory();

        factory.createNote().edit();
        factory.createVideo().record();

    }

}
