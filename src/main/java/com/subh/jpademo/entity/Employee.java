package com.subh.jpademo.entity;

import com.subh.jpademo.entity.customentity.EmployeeManagerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



@NamedNativeQuery(name = "Employee.getEmployeeManagerNative",
        query = "select e.id as employeeId, e.name as employeeName, m.name as managerName from employee e left join employee m on e.id = m.manager_id",
        resultSetMapping = "Mapping.EmployeeManagerDto")
@SqlResultSetMapping(name = "Mapping.EmployeeManagerDto",
        classes = @ConstructorResult(targetClass = EmployeeManagerDto.class,
        columns = {@ColumnResult(name = "employeeId"), @ColumnResult(name = "employeeName"), @ColumnResult(name = "managerName")})
)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String department;
    private int managerId;
    private BigDecimal salary;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "book_id", referencedColumnName = "bookId")

    @OneToMany(targetEntity = Book.class, /*mappedBy = "employee",*/ cascade = CascadeType.ALL)
    @JoinColumn(name = "eb_fk", referencedColumnName = "id")
    private List<Book> bookList;




}
