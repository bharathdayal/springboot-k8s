package com.example.demo.components;

import com.example.demo.interfaces.Payment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class GPay implements Payment {

   @Override
    public String mode() {
        return "Google Pay";
    }
}


