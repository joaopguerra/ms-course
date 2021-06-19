package com.guerra.hrpayroll.resources;

import com.guerra.hrpayroll.entities.Payment;
import com.guerra.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);

        return payment;
    }

    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = Payment.builder()
                .name("Brann")
                .dailyIncome(400.0)
                .days(days)
                .build();
        return payment;
    }

}
