package com.subh.jpademo.controller;

import com.subh.jpademo.controller.handleException.GeneralException;
import com.subh.jpademo.entity.Book;
import com.subh.jpademo.entity.Employee;
import com.subh.jpademo.entity.customentity.EmployeeBook;
import com.subh.jpademo.entity.customentity.EmployeeManagerDto;
import com.subh.jpademo.repository.EmployeeRepo;
import com.subh.jpademo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@Controller
@ResponseBody
@RequestMapping("/api")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    @Lazy
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo employeeRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RestTemplate restTemplate;

    @DeleteMapping
    public void deleteEmployeBySalaryNull(){
       // employeeRepo.deleteEmployeesBySalaryNull();
        employeeRepo.deleteEmployeesBySalaryNull();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmploeeById(@PathVariable int id) {
        logger.info("getting employee for id : {}",  id);
        Optional<Employee> employeeOptional =  employeeService.getEmployeeById(id);
        Employee employee;

        if(!employeeOptional.isPresent())
            throw new GeneralException("employee not found");
        else employee = employeeOptional.get();
        /*employee.setName("modified name");

        entityManager.detach(employee);

        employeeRepo.flush();*/

        return employee;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.saveEmployee(employee);
        emp.setName("modi");
        return emp;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employeeManager")
    public List<EmployeeManagerDto> getAllEmployeeWithManager(){
        return employeeRepo.getEmployeeManager();
    }

    @GetMapping("/employeeManagerNative")
    public List<EmployeeManagerDto> getAllEmployeeWithManagerNative(){
        return employeeRepo.getEmployeeManagerNative();
    }

    @GetMapping("/employee-book")
    public List<EmployeeBook> getJoinInfo(){
        return employeeRepo.getJoinInfo();
    }



    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
       /* Employee empDb = employeeRepo.findById(employee.getId()).get();
        Book dbBook = empDb.getBookList().get(0);
        dbBook.setName("updated book");*/

        return employeeRepo.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeRepo.deleteById(id);
        employeeRepo.delete(new Employee());
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeRepo.delete(employee);
    }


}
