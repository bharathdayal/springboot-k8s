package com.example.demo.controllers;

import com.example.demo.annotations.CustomLogAnnotation;
import com.example.demo.components.CreditCard;
import com.example.demo.components.Paypal;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.interfaces.Payment;

import java.text.ParseException;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final CreditCard creditCard;

    private final Paypal paypal;


    @GetMapping(path="/mode")
    public ResponseEntity<String> getAllPaymentMode(@RequestParam String paymentMode) throws ParseException {

       String mode ="";

           mode +=    paymentMode.equals("Credit") ? creditCard.paymentMethod(paymentMode)+creditCard.transactionDate():
                      paymentMode.equals("Paypal") ? creditCard.paymentMethod(paymentMode)+paypal.transactionDate():
                      "No payment method found";


        return new ResponseEntity<>(mode, HttpStatus.OK);
    }

    @CustomLogAnnotation
    @GetMapping("/api/message")
    public String displayDeployMessage() {
        return "Running in Kubernets k8 cluster";
    }

}
