package com.example.payroll.payrolldemo.services;

import com.example.payroll.payrolldemo.entities.Employee;
import com.example.payroll.payrolldemo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public Employee update(Employee employeeToUpdate){
        return employeeRepository.save(employeeToUpdate);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }
}
