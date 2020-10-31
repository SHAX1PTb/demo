package com.example.Customer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ExceptionKillingThread {

    private static Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable job = () -> {

            while (queue.isEmpty());
            System.out.println("queue is not empty");
        };

        Thread thread = new Thread(job);
        thread.start();
        Thread.sleep(500);
        queue.add(42);
        //queue = null;
    }


}
