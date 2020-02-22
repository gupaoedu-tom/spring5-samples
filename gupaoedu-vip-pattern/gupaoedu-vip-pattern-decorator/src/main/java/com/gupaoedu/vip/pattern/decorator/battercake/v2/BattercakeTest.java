package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom on 2019/3/17.
 */
public class BattercakeTest {
    public static void main(String[] args) {

        Battercake battercake;
        //路边摊买一个煎饼
        battercake = new BaseBattercake();
        //煎饼有点小，想再加一个鸡蛋
        battercake = new EggDecorator(battercake);
        //再加一个鸡蛋
//        battercake = new EggDecorator(battercake);
        //很饿，再加根香肠
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);


        //跟静态代理最大区别就是职责不同
        //静态代理不一定要满足is-a的关系
        //静态代理会做功能增强，同一个职责变得不一样

        //装饰器更多考虑是扩展

        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());


    }

}
