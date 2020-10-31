package com.example.Customer;

public class Singeleton {
    private static Singeleton instance;

//    private Singeleton() {
//    }

    public static synchronized Singeleton getInstance() {
        if (instance == null) instance = new Singeleton();

        return instance;
    }
}
