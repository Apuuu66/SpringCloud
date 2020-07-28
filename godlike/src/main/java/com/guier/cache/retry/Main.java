package com.guier.cache.retry;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;

import java.io.IOException;
import java.util.concurrent.Callable;

public class Main {
    private static Callable<Void> runtimeExceptionTask = new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            System.out.println("runtime was called.");
            throw new NullPointerException("runtime");
        }
    };

    private static Callable<Void> checkedExceptionTask = new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            System.out.println("checked was called.");
            throw new IOException("checked");
        }
    };

    private static Callable<Void> errorTask = new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            System.out.println("error was called.");
            throw new ThreadDeath();
        }
    };

    public static void main(String[] args) {
        // retryIfException，抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
        Retryer<Void> retryer = RetryerBuilder.<Void>newBuilder()
                .retryIfException() // 抛出异常时重试
                .withStopStrategy(StopStrategies.stopAfterAttempt(3)) // 重试3次后停止
                .build();
        // retryIfRuntimeException只会在抛runtime异常的时候才重试，checked异常和error都不重试。
        try {
            retryer.call(checkedExceptionTask);
        } catch (Exception e) {

        }

        try {
            retryer.call(runtimeExceptionTask);
        } catch (Exception e) {

        }

        try {
            retryer.call(errorTask);
        } catch (Exception e) {

        }
    }


}
