package com.guier.configclient.service.impl;

import com.guier.configclient.dao.WorkerRepository;
import com.guier.configclient.pojo.Worker;
import com.guier.configclient.service.UserService;
import com.guier.configclient.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    UserService userService;

    /**
     * 事务生效的情况：
     * 1. 数据库支持事务
     * 2. 方法必须是public，另外private，final，static不能添加事务，不生效
     * 3. 异常必须是RuntimeException子类
     * 4. @EnableTransactionManagement未开启，在springboot1.4以后可以不写
     * 5. 业务和事务必须在一个线程里
     */
    @Override
    @Transactional
    public void addWorker() {
        Worker worker = new Worker("小李", new BigDecimal("23"));
        workerRepository.save(worker);
        int x = 1 / 0;
        System.out.println(x);
    }

    @Override
    // @Transactional
    public void updateWorker() {
        Worker worker = workerRepository.findById(1L).orElse(null);
        // worker.setName(worker.getName()+"-back");
        worker.setName("张三");
        workerRepository.save(worker);
        int x = 1 / 0;
    }

    @Override
    @Transactional
    public void testTransaction() {
        updateWorker();
        // int x = 1 / 0;
    }

    @Transactional
    public void create() {
        Worker worker = new Worker("小李", new BigDecimal("23"));
        workerRepository.save(worker);

        try {
            userService.save();
        } catch (Exception e) {
            System.out.println("不断程序，用来输出日志~");
        }
        // System.out.println(1 / 0); //此处抛出异常，事务回滚，因此save不会生效
    }
}
