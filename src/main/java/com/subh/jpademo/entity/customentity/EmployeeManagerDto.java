package com.subh.jpademo.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeManagerDto {

    private int employeeId;
    private String employeeName;
    private String managerName;

}
