package com.guier.configclient.dao;

import com.guier.configclient.pojo.Worker;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("select w from Worker w where w.id=(select MAX(id) from Worker )")
    Worker getMaxIdWorker();

    @Query("select w from Worker w where name = ?1 and salary >= ?2")
    List<Worker> findWorkerByFirstParam(String name, BigDecimal salary);

    @Query("select w from Worker w where name = :name and salary >= :salary")
    List<Worker> findWorkerBySecondParam(@Param("name") String name, @Param("salary") BigDecimal salary);

    // 只查询部分字段
    @Query("select new Worker(w.name,w.salary) from Worker w")
    // @Query("select w.name,w.salary from Worker w") X
    List<Worker> getWorkerByNameAndSalaryInfo();

    // 原声查询
    @Query(value = "select * from worker", nativeQuery = true)
    List<Worker> findAllByNativeQuery();

    @Query(value = "select w.name,w.salary from worker w", nativeQuery = true)
    List<Map<String, Object>> getWorkerNameAndSalaryInfoByNativeQuery();


    @Modifying
    @Transactional(readOnly = false)
    @Query("UPDATE Worker SET salary = :salary WHERE name = :name")
    int updateSalaryByName(@Param("salary") BigDecimal salary, @Param("name") String name);

    // 排序
    List<Worker> findAllBySalaryGreaterThanEqual(BigDecimal salary, Sort sort);
}
