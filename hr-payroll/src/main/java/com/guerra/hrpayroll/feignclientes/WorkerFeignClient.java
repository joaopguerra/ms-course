package com.guerra.hrpayroll.feignclientes;

import com.guerra.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Worker findById(@PathVariable Long id);
}
