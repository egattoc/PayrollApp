package com.example.payroll.payrolldemo.requests;

import com.example.payroll.payrolldemo.entities.Employee;

public record CreateEmployeeInput(String name, String position, double salary, String address, String department, String supervisor) {
    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setAddress(address);
        employee.setDepartment(department);
        employee.setSupervisor(supervisor);
        return employee;
    }
}
