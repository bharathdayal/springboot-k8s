package com.example.demo.services;

import com.example.demo.interfaces.Payment;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public abstract class PaymentService {

    private final Payment payment;

    public PaymentService(@Qualifier("gpay") Payment payment) {
        this.payment=payment;
    }

    public String getPaymentMode() {
        return this.payment.mode();
    }
}
