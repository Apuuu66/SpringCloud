package com.guier.java.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        Object e = new Object();
        // arrayBlockingQueue.add(e);
        arrayBlockingQueue.add(e);
        // arrayBlockingQueue.add(e);
        // arrayBlockingQueue.add(e);
        arrayBlockingQueue.remove();
        // System.out.println(arrayBlockingQueue.offer(e,5L,TimeUnit.SECONDS));
        // System.out.println(arrayBlockingQueue.size());


        // LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
        // linkedBlockingQueue.element();
        //
        // PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(1);
        // priorityBlockingQueue.put(e);
    }
}
