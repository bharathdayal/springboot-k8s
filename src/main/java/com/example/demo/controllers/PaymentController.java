package com.example.demo.controllers;

import com.example.demo.annotations.CustomLogAnnotation;
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
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.interfaces.Payment;

@RestController
public class PaymentController {


    private final Payment payment;


    public   PaymentService paymentService;

    public PaymentController(Payment payment) {
        this.payment = payment;
    }

    @GetMapping("/api/payment")
    public ResponseEntity<String> getAllPaymentMode() {
        String mode =this.payment.mode();
        //String mode1 = this.paymentService.getPaymentMode();
        return new ResponseEntity<>(mode, HttpStatus.OK);
    }

    @CustomLogAnnotation
    @GetMapping("/api/message")
    public String displayDeployMessage() {
        return "Running in Kubernets k8 cluster";
    }

}
