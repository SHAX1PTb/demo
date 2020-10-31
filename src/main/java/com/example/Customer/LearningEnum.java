package com.example.Customer;


enum Mobile implements Car {
APPLE(100,"CHINA"),SAMSUNG(200, "INPUT"),HTC(300, "INPUT");

    //private static String country;
    private final int price;
    private final String country;

    public String getCountry() {
        return country;
    }

    Mobile(int i, String country) {
        price = i;
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void addAdhar() {
        System.out.println("inside enum");

    }

    @Override
    public void addition() {

    }

    @Override
    public void substraction() {

    }
}
public class LearningEnum {
    public static void main(String[] args) {
        //System.out.println(Mobile.APPLE.getPrice());
        Mobile.APPLE.addAdhar();
      //  System.out.println(Mobile.APPLE.addAdhar(););

        Mobile e[] = Mobile.values();


        for(Mobile mobile : e){
            System.out.println(mobile);
        }
    }


}
