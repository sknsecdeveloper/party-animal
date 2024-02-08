package com.subh.jpademo;

import com.subh.jpademo.entity.Employee;
import com.subh.jpademo.repository.EmployeeRepo;
import com.subh.jpademo.repository.OrderNewRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpAdemoApplicationTests {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private OrderNewRepo orderNewRepo;


    @Test
    public void saveUserDataInDB(){
        Employee employee = Employee.builder().id(9999).name("subhash").department("IT").build();

        employeeRepo.save(employee);
        Employee employee1 = employeeRepo.findById(123).get();
        System.out.println(employee1);
    }
}
