package com.guier.configclient.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerRepositoryTest {
    @Autowired
    WorkerRepository workerRepository;

    @Test
    public void query() {
        workerRepository.findAll().forEach(System.out::println);
        System.out.println(workerRepository.findById(1L));
        System.out.println(workerRepository.findById(4L));
    }

    @Test
    public void jpql() {
        System.out.println(workerRepository.getMaxIdWorker());
        System.out.println(workerRepository.findWorkerByFirstParam("张三", new BigDecimal(200)));
        System.out.println(workerRepository.findWorkerBySecondParam("张三", new BigDecimal(200)));
        System.out.println(workerRepository.getWorkerByNameAndSalaryInfo());
        System.out.println(workerRepository.findAllByNativeQuery());
    }
}