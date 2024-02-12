package com.subh.jpademo.repository;

import com.subh.jpademo.entity.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepoPage extends PagingAndSortingRepository<Employee, Integer> {

    //List<Employee> findAllBySalary(BigDecimal salary, Pageable pageable);
}
