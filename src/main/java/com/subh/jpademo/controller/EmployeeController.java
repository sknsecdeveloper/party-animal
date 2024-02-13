package com.subh.jpademo.controller;

import com.subh.jpademo.controller.handleException.GeneralException;
import com.subh.jpademo.entity.employee.Employee;
import com.subh.jpademo.entity.customentity.EmployeeBook;
import com.subh.jpademo.entity.customentity.EmployeeManagerDto;
import com.subh.jpademo.repository.EmployeeRepo;
import com.subh.jpademo.repository.EmployeeRepoPage;
import com.subh.jpademo.service.EmployeeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@ApiResponse
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    //@Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    @Lazy
    private EmployeeService employeeService;


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RestTemplate restTemplate;

    /*@Autowired*/
    private EmployeeRepoPage employeeRepoPage;

    @GetMapping("/hello")
    public String getMsg(){
        return "Hello";
    }


    @GetMapping("/page/{pageNumber}/{pageSize}")
    public List<Employee> getEmployeeListWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepoPage.findAll(pageable).stream().toList();
        //return employeeRepoPage.findAll(pageable);

    }

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

    @PostMapping(value = "/employee", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )

    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees", produces = {/*MediaType.APPLICATION_JSON_VALUE,*/ MediaType.APPLICATION_XML_VALUE})
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
