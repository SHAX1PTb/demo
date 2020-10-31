package com.example.Customer;

import javafx.concurrent.Task;

public class AddNumbers extends NewCompany implements RBI,Car{

    int add(int... a) {
        int c = 0;
        for (int loop : a) {
            c = c + loop;
        }
//        System.out.println("inside add"+a[1]);
//           return 0;

        return c;
    }

    public static void main(String... args) throws InterruptedException {

        Runnable task = () -> {
            AddNumbers addNumbers = new AddNumbers();
            addNumbers.addAdhar();
            addNumbers.addition();
            addNumbers.multiplication();
            int b = addNumbers.add(10, 20, 30);

            System.out.println("total sum" + b);
        };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();





    }

    @Override
    public void addAdhar() {
        System.out.println("Adhar Linked");
    }

    @Override
    public void addition() {
        System.out.println("Amount added");

    }

    @Override
    public void substraction() {
        System.out.println("amount substaracted");

    }

//    @Override
    public void multiplication() {
        System.out.println("i am in main");
    }
}
