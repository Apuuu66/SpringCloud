package com.guier.java.queue;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleBlockingQueue {
    private ReentrantLock lock = new ReentrantLock();
    private LinkedList<Integer> list = new LinkedList<>();
    private Condition isFull = lock.newCondition();
    private Condition isNull = lock.newCondition();
    private int maxsSize;

    public SimpleBlockingQueue() {
        this(10);
    }

    public SimpleBlockingQueue(int maxsSize) {
        this.maxsSize = maxsSize;
    }

    public void put(Integer e) {
        try {
            lock.lock();
            try {
                while (list.size() == maxsSize) {
                    System.out.println("队列满了，等待消费数据");
                    isFull.await();
                }
            } finally {
                isFull.signal();
            }

            list.addFirst(e);
            isNull.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Integer get() {
        try {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println("队列中暂时还没数据，等待生产数据");
                    isNull.await();
                }
            } finally {
                isNull.signal();
            }
            Integer e = list.removeLast();
            isFull.signal();
            return e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


    public int getMaxsSize() {
        return list.size();
    }

    public static void main(String[] args) {
        Random random = new Random();
        SimpleBlockingQueue sbq = new SimpleBlockingQueue();
        // SBlockingQueue<Integer> sbq = new SBlockingQueue<>();
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    sbq.put(random.nextInt(1000));
                    Thread.sleep(random.nextInt(100));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                Integer item = sbq.get();
                System.out.println(item);
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t2.start();
        t1.start();
    }

}
