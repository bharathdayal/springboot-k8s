package com.example.demo.components;

import com.example.demo.interfaces.Payment;
import com.example.demo.interfaces.Transaction;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class Paypal implements Payment, Transaction {

    @Override
    public String paymentMethod(String mode) {
        System.out.println("Paypal Method===>"+mode);
        return "Payment Method===>  "+mode+" Paypal Transaction Date ===>";
    }

    public LocalDate transactionDate()  {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return LocalDate.now();
    }

}
