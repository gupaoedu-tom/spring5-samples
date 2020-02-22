package com.gupaoedu.vip.pattern.singleton.test;

import com.gupaoedu.vip.pattern.singleton.lazy.LazyDoubleCheckSingleton;
import com.gupaoedu.vip.pattern.singleton.lazy.LazySimpleSingleton;
import com.gupaoedu.vip.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created by Tom.
 */
public class ExectorThread implements Runnable{

    public void run() {

        LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
