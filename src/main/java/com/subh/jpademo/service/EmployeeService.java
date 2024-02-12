package com.subh.jpademo.service;

import com.subh.jpademo.entity.employee.Employee;
import com.subh.jpademo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeService(){
        System.out.println("EmployeeService bean created");
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @Override
    public void print() {

    }
}
