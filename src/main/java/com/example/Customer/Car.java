package com.example.Customer;

public interface Car {

    void addAdhar();

     void addition();

      void substraction();

      default void multiplication(){
          System.out.println(" i am in mutliplication");
      }
}
