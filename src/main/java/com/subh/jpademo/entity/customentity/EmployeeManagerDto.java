package com.subh.jpademo.entity.customentity;


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
