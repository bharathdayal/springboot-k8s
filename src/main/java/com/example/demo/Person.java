package com.example.demo;

import lombok.Getter;
import lombok.Setter;

public class Person {

  @Setter
  @Getter
  private String personname;
  @Getter

  private Integer personage;

    public void setPersonage(int age) {
        if (age > 0) {
            this.personage = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }


}
