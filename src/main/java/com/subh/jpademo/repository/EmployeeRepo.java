package com.subh.jpademo.repository;

import com.subh.jpademo.entity.Employee;
import com.subh.jpademo.entity.customentity.EmployeeBook;
import com.subh.jpademo.entity.customentity.EmployeeManagerDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "delete from Employee where salary is null", nativeQuery = true)
    public void testdeleteEmployeesBySalaryNull();

    public void deleteEmployeesBySalaryNull();

    //self join : find employee his manager name
    @Query(value = "select new com.subh.jpademo.entity.customentity.EmployeeManagerDto (e.id, e.name , m.name) from Employee e  join Employee m on e.managerId = m.id", nativeQuery = false)
    public List<EmployeeManagerDto> getEmployeeManager();

    @Query(nativeQuery = true)
    public List<EmployeeManagerDto> getEmployeeManagerNative();


    @Query(value = "select new com.subh.jpademo.entity.customentity.EmployeeBook( e.name, b.name ) from Employee e join e.bookList b")
    public List<EmployeeBook> getJoinInfo();






}
