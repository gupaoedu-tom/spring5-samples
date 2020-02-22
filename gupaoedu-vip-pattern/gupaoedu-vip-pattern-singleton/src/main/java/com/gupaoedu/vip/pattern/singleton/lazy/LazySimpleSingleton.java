package com.gupaoedu.vip.pattern.singleton.lazy;

/**
 * Created by Tom.
 */

//懒汉式单例
//在外部需要使用的时候才进行实例化
public class LazySimpleSingleton {
    private LazySimpleSingleton(){}
    //静态块，公共内存区域
    private static LazySimpleSingleton lazy = null;

//    public static LazySimpleSingleton getInstance(){
//        if(lazy == null){
//            lazy = new LazySimpleSingleton();
//        }
//        return lazy;
//    }


    public synchronized static LazySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
