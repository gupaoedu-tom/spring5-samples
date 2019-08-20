package com.gupaoedu.vip.design.principle.liskovsubstitution.simple;

/**
 * Created by Tom.
 */
public class SimpleTest {
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("width:"+rectangle.getWidth() +
                    ",height:"+rectangle.getHeight());
        }
        System.out.println("resize方法结束" +
                "\nwidth:"+rectangle.getWidth() +
                ",height:"+rectangle.getHeight());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);
    }

//    public static void main(String[] args) {
//        Square square = new Square();
//        square.setLength(10);
//        resize(square);
//    }
}
