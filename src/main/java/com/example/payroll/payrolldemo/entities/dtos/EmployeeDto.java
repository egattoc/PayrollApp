package com.example.payroll.payrolldemo.entities.dtos;

import com.example.payroll.payrolldemo.entities.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "The name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    private String name;

    @NotBlank(message = "The position is required")
    private String position;

    @Min(80000)
    @Max(200000)
    private double salary;

    private String address;

    @NotBlank(message = "The department is required")
    private String department;

    @NotBlank(message = "The supervisor is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    private String supervisor;

    public Employee toEmployee(){
        Employee e = new Employee();
        e.setName(name);
        e.setPosition(position);
        e.setSalary(salary);
        e.setAddress(address);
        e.setDepartment(department);
        e.setSupervisor(supervisor);
        return e;
    }
}
