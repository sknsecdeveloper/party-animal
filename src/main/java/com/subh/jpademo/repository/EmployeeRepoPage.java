package com.subh.jpademo.repository;

import com.subh.jpademo.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepoPage extends PagingAndSortingRepository<Employee, Integer> {

    //List<Employee> findAllBySalary(BigDecimal salary, Pageable pageable);
}
