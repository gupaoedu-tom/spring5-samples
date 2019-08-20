package com.gupaoedu.vip.design.principle.openclose;

/**
 * Created by Tom
 */
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice(){
        return super.getPrice() * 0.61;
    }

//    public Double getOriginPrice(){
//        return super.getPrice();
//    }
//
//    public Double getPrice(){
//        return super.getPrice() * 0.61;
//    }



}
