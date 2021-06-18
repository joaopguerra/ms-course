package com.guerra.hrworker.resources;

import com.guerra.hrworker.entities.Worker;
import com.guerra.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private final Environment env;

    private final WorkerRepository workerRepository;

    public WorkerResource(WorkerRepository workerRepository, Environment env) {
        this.workerRepository = workerRepository;
        this.env = env;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAll(){
        List<Worker> list = workerRepository.findAll();

        return list;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Worker findById(@PathVariable Long id) throws Exception {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Optional<Worker> worker = workerRepository.findById(id);

        return worker.orElseThrow(Exception::new);
    }
}
