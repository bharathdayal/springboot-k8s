package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
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
