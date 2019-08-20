package com.gupaoedu.vip.design.principle.openclose;

/**
 * Created by Tom.
 */
public class OpenCloseTest {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(232, "【咕泡学院】Java架构师专题课", 11800D);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + javaCourse.getId() +
                "\n课程名称:《" + javaCourse.getName() + "》" +
                "\n原价:" + javaCourse.getPrice()  + "元" +
                "\n折后价:" + javaCourse.getDiscountPrice() + "元");

//        ICourse iCourse = new JavaDiscountCourse(232, "【咕泡学院】Java架构师专题课", 11800D);
//        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
//        System.out.println("课程ID:" + javaCourse.getId() +
//                "\n课程名称:《" + javaCourse.getName() + "》" +
//                "\n原价:" + javaCourse.getOriginPrice()  + "元" +
//                "\n折后价:" + javaCourse.getPrice() + "元");

    }
}
