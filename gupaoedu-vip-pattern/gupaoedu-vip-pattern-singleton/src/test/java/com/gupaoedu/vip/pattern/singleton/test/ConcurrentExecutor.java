package com.gupaoedu.vip.pattern.singleton.test;

import java.util.concurrent.*;

/**
 * Created by Tom.
 */
public class ConcurrentExecutor {
    /**
     * @param runHandler
     * @param executeCount 发起请求总数
     * @param concurrentCount 同时并发执行的线程数
     * @throws Exception
     */
    public static void execute(final RunHandler runHandler,int executeCount,int concurrentCount) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //控制信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(concurrentCount);
        //闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executeCount);
        for (int i = 0; i < executeCount; i ++){
            executorService.execute(new Runnable() {
                public void run() {
                    try{
                        //执行此方法用于获取执行许可，当总计未释放的许可数不超过executeCount时,
                        //则允许同性，否则线程阻塞等待，知道获取到许可
                        semaphore.acquire();
                        runHandler.handler();
                        //释放许可
                        semaphore.release();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//线程阻塞，知道闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();
    }
    public interface RunHandler{
        void handler();
    }
}
