/*
 * ExecuteExample
 * java8to11
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-15.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package me.raemerrr.java.multithread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                int poolSize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();
                System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);

                //예외 발생
                int value = Integer.parseInt("삼");
                System.out.println("예외 이후");
            };

            //executorService.execute(runnable);
            executorService.submit(runnable);
            Thread.sleep(10);
        }
        executorService.shutdown();
    }
}
