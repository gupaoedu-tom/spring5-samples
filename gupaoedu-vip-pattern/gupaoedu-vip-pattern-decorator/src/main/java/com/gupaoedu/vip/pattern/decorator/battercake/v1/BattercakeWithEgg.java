package com.gupaoedu.vip.pattern.decorator.battercake.v1;

/**
 * Created by Tom on 2019/3/17.
 */
public class BattercakeWithEgg extends Battercake{
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    //加一个鸡蛋加1块钱
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
