package com.example.Customer;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadCreationCost {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {


        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                running = false;
            }
        }, 1000);

        Runnable task = () -> {
            //   System.out.printf(" This is core logic");
        };

        long count = 0;

        ThreadGroup threadGroup = new ThreadGroup("test");
        while (running) {
            Thread thread = new Thread(threadGroup,task);
            thread.start();
            System.out.println(thread.getThreadGroup().getName());

            thread.join();


            count++;

        }

        System.out.printf("count:" + count);

    }
}
