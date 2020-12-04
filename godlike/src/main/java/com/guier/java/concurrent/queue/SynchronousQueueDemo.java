package com.guier.java.concurrent.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {


    public static void main(String[] args) {
        SynchronousQueue<Runnable> workQueue = new SynchronousQueue<>(true);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 2, 60, TimeUnit.SECONDS, workQueue);

        executor.execute(()-> System.out.println(123));
    }











    // public static void main(String[] args) throws InterruptedException {
    //     final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>(true);
    //     // Random random = new Random();
    //     // Thread putThread1 = new Thread(new Runnable() {
    //     //     @Override
    //     //     public void run() {
    //     //         while (true) {
    //     //             System.out.println("put 1 thread start");
    //     //             try {
    //     //                 queue.put(1);
    //     //                 System.out.println(queue.size());
    //     //
    //     //                 int millis = random.nextInt(100);
    //     //                 Thread.sleep(millis);
    //     //                 System.out.println("put 1 thread end");
    //     //             } catch (InterruptedException ignored) {
    //     //             }
    //     //         }
    //     //     }
    //     // });
    //     //
    //     // Thread putThread2 = new Thread(new Runnable() {
    //     //     @Override
    //     //     public void run() {
    //     //         while (true) {
    //     //             System.out.println("put 2 thread start");
    //     //             try {
    //     //                 queue.put(2);
    //     //                 System.out.println(queue.size());
    //     //                 int millis = random.nextInt(100) + 200;
    //     //                 Thread.sleep(millis);
    //     //                 System.out.println("put 2 thread end");
    //     //             } catch (InterruptedException ignored) {
    //     //             }
    //     //         }
    //     //     }
    //     // });
    //     //
    //     // Thread takeThread = new Thread(() -> {
    //     //     while (true) {
    //     //         System.out.println("take thread start");
    //     //         try {
    //     //             System.out.println("take from putThread: " + queue.take());
    //     //             // int millis = random.nextInt(800) + 200;
    //     //             System.out.println("take thread end");
    //     //             // Thread.sleep(millis);
    //     //         } catch (InterruptedException ignored) {
    //     //         }
    //     //     }
    //     // });
    //     //
    //     // putThread1.start();
    //     // putThread2.start();
    //     new Thread(() -> {
    //         try {
    //             System.out.println("take from putThread: " + queue.take());
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }).start();
    //     new Thread(() -> {
    //         try {
    //             System.out.println("take from putThread: " + queue.take());
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }).start();
    //
    //     Thread.sleep(3000);
    //     // takeThread.start();
    //     Thread t1 = new Thread(() -> {
    //         try {
    //             queue.put(1);
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //
    //     });
    //     Thread t2 = new Thread(() -> {
    //         try {
    //             queue.put(2);
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //
    //     });
    //     t1.start();
    //     t2.start();
    //
    //
    // }
    //
}
