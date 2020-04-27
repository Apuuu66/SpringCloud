package com.guier.java.concurrent.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// https://juejin.im/entry/596a05fdf265da6c4f34f2f9
public class CyclicBarrierDemo {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TourGuideTask());

    public static void main(String[] args) throws InterruptedException {
        test();
        // Executor executor = Executors.newFixedThreadPool(3);
        // //登哥最大牌，到的最晚
        // for (int i = 1; i < 4; i++) {
        //     executor.execute(new TravelTask(cyclicBarrier, "哈登" + i + "号", 5));
        //     executor.execute(new TravelTask(cyclicBarrier, "保罗" + i + "号", 3));
        //     executor.execute(new TravelTask(cyclicBarrier, "戈登" + i + "号", 1));
        // }
        //
        // ((ExecutorService) executor).shutdown();
    }

    static class TourGuideTask implements Runnable {

        @Override
        public void run() {
            System.out.println("****导游分发护照签证****");
            try {
                //模拟发护照签证需要2秒
                Thread.sleep(2000);
                System.out.println(cyclicBarrier.isBroken());
                System.out.println(cyclicBarrier.getParties());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TravelTask implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;
        private int arriveTime;//赶到的时间

        public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
            this.arriveTime = arriveTime;
        }

        @Override
        public void run() {
            try {
                //模拟达到需要花的时间
                Thread.sleep(arriveTime * 1000);
                int i = cyclicBarrier.getNumberWaiting() + 1;
                System.out.println(name + "到达集合点,已到达" + i + "个");
                cyclicBarrier.await();
                // cyclicBarrier.await(arriveTime, TimeUnit.MILLISECONDS);
                System.out.println(name + "开始旅行啦～～");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    private static void test() throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Round " + count.addAndGet(1) + "-各就位！预备！");
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();

        // for (int i = 0; i < 100; i++) {
        //     int finalI = i;
        //     exec.submit(() -> {
        //         try {
        //             int millis = new Random().nextInt(1000) * 5+500;
        //             Thread.sleep(millis);
        //             System.out.println(finalI +Thread.currentThread().getName()+ "让大家等了 " + millis);
        //             // cb.await();
        //             cb.await(new Random().nextInt(500)+100, TimeUnit.MILLISECONDS);
        //         } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
        //             System.out.println(Thread.currentThread().getName());
        //             e.printStackTrace();
        //         }
        //     });
        // }

        exec.submit(() -> {
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        exec.submit(() -> {
            try {
                // cb.await();
                cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        Thread.sleep(1000);
        exec.submit(() -> {
            try {

                cb.await();
                // cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        if (cyclicBarrier.isBroken()) cyclicBarrier.reset();
        exec.submit(() -> {
            try {

                cb.await();
                // cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });

        exec.submit(() -> {
            try {
                cb.await();
                // cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        exec.submit(() -> {
            try {
                cb.await();
                // cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        exec.submit(() -> {
            try {
                cb.await();
                // cb.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        });
        exec.shutdown();
    }
}
