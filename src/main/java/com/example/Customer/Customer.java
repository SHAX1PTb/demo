package com.example.Customer;

public class Customer {
    Long ID;
    String EMAIL;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Customer(Long ID, String EMAIL) {
        this.ID = ID;
        this.EMAIL = EMAIL;
    }
}
