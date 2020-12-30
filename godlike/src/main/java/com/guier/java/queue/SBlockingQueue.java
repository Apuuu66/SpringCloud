package com.guier.java.queue;

import java.util.ArrayDeque;

public class SBlockingQueue<E> {

    //基本参数与数据容器
    private final static int DEFAULT_MAX_COUNT = 10;
    private final int maxCount;
    private final ArrayDeque<E> blockingQueue;

    public SBlockingQueue() {
        this(DEFAULT_MAX_COUNT);
    }

    public SBlockingQueue(int size) {
        blockingQueue = new ArrayDeque<>(size);
        maxCount = size;
    }


    public void put(E e) {
        synchronized (blockingQueue) {
            while (blockingQueue.size() == maxCount) {
                try {
                    System.out.println("队列满了，等待消费数据");
                    blockingQueue.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            blockingQueue.add(e);
            blockingQueue.notifyAll();
        }
    }

    public E get() {
        synchronized (blockingQueue) {
            while (blockingQueue.size() == 0) {
                try {
                    System.out.println("队列中暂时还没数据，等待生产数据");
                    blockingQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            blockingQueue.notifyAll();
            return blockingQueue.removeFirst();
        }
    }

    public int size() {
        return blockingQueue.size();
    }

}


