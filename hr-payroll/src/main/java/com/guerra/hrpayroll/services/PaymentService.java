package com.guerra.hrpayroll.services;

import com.guerra.hrpayroll.entities.Payment;
import com.guerra.hrpayroll.entities.Worker;
import com.guerra.hrpayroll.feignclientes.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId);

        return Payment.builder()
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .days(days)
                .build();
    }
}
