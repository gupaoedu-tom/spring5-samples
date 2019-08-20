package com.gupaoedu.vip.design.principle.liskovsubstitution;

/**
 * Created by Tom
 */
public class LiskovSubstitutionTest {
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <= rectangle.getHeight()){
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println("width:"+rectangle.getWidth() +
                                "\nheight:"+rectangle.getHeight());
        }
        System.out.println("resize方法结束" +
                            "\nwidth:"+rectangle.getWidth() +
                            "\nheight:"+rectangle.getHeight());
    }

//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(10);
//        rectangle.setHeight(20);
//        resize(rectangle);
//    }
    public static void main(String[] args) {
        Square square = new Square();
        square.setLength(10);
//        resize(square);
    }


}
