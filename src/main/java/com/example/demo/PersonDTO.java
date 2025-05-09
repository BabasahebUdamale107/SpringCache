package com.example.demo;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private String name;
    private String address;

    // Constructors
    public PersonDTO() {}

    public PersonDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
