package com.guerra.hrpayroll.services;

import com.guerra.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return Payment.builder()
                .name("Bob")
                .dailyIncome(200.0)
                .days(days)
                .build();
    }
}
