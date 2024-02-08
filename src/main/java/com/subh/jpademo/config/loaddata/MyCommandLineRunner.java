package com.subh.jpademo.config.loaddata;

import com.subh.jpademo.entity.Book;
import com.subh.jpademo.entity.Employee;
import com.subh.jpademo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@Configuration
@Lazy
public class MyCommandLineRunner implements CommandLineRunner {

    @Bean
    public RestTemplate restTemplate(){
        System.out.println("RestTemplate bean create............d");
        return new RestTemplate();
    }

    //@Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {

        /*System.out.println("Environment =============== "+environment.getActiveProfiles().length);

        Random random = new Random();
        String[] departments = {"IT", "CSE", "ECE"};
        int randomIndex = random.nextInt(departments.length);

        List<Employee> employees = new ArrayList<>();
        IntStream.range(1, 101).forEachOrdered(

                value -> {
                    Employee employee = new Employee();
                    employee.setName("subhash_"+value);
                    employee.setDepartment(departments[random.nextInt(departments.length)]);
                    employee.setManagerId(random.nextInt(1,101));
                    employee.setSalary(BigDecimal.valueOf(random.nextInt(1,101)*3333.333));

                    Book book1 = new Book();
                    book1.setName("learn spring version-"+value);
                    Book book2 = new Book();
                    book2.setName("learn Spring Data JPA-"+value);
                    employee.setBookList(Arrays.asList(book1,book2));

                    employees.add(employee);
                }

              );
        long empCount = employeeRepo.count();
        if(empCount<0 || empCount<150 ) {
            employeeRepo.saveAll(employees);
        }*/

    }
}
