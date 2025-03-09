package com.example.demo.components;

import com.example.demo.interfaces.Payment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class ApplePay implements Payment {



    @Override
    public String mode() {
        return "Apple Pay";
    }
}