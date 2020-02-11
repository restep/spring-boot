package com.restep.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author restep
 * @date 2019/11/3
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 30, 3L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024), new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.AbortPolicy());

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                executorService.execute(() -> {
                    System.out.println("线程: " + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(3L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

            while (true) {
                boolean flag = executorService.isShutdown();
                if (flag) {
                    executorService.shutdown();
                }

                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
