package com.gupaoedu.vip.design.principle.liskovsubstitution;

/**
 * 长方形
 * Created by Tom
 */
public class Rectangle implements Quadrangle {
    private long height;
    private long width;

    @Override
    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
