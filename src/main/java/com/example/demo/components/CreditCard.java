package com.example.demo.components;

import com.example.demo.interfaces.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class CreditCard implements Payment {

    @Override
    public String paymentMethod(String mode) {
        System.out.println("CreditCard Method===>"+mode);
        return "Payment Method===>  "+mode+" Credit Card Transaction Date ===>";
    }


    public LocalDate transactionDate() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return LocalDate.now();
    }
}
