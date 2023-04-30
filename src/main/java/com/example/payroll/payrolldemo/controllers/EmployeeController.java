package com.example.payroll.payrolldemo.controllers;

import com.example.payroll.payrolldemo.entities.Employee;
import com.example.payroll.payrolldemo.entities.dtos.EmployeeDto;
import com.example.payroll.payrolldemo.requests.CreateEmployeeInput;
import com.example.payroll.payrolldemo.requests.UpdateEmployeeInput;
import com.example.payroll.payrolldemo.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        Employee employeeCreated = employeeService.create(employeeDto.toEmployee());
        return new ResponseEntity<>(employeeCreated, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> allEmployees(){
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> oneEmployee(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isPresent()) {
            return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeInput updateEmployeeInput) {
        Optional<Employee> optionalTask = employeeService.findById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employeeToUpdate = optionalTask.get();
        if(updateEmployeeInput.name() != null) {
            employeeToUpdate.setName(updateEmployeeInput.name());
        }
        if(updateEmployeeInput.position() != null) {
            employeeToUpdate.setPosition(updateEmployeeInput.position());
        }
        if(updateEmployeeInput.salary() != 0) {
            employeeToUpdate.setSalary(updateEmployeeInput.salary());
        }
        if(updateEmployeeInput.address() != null) {
            employeeToUpdate.setAddress(updateEmployeeInput.address());
        }
        if(updateEmployeeInput.department() != null) {
            employeeToUpdate.setDepartment(updateEmployeeInput.department());
        }
        if(updateEmployeeInput.supervisor() != null) {
            employeeToUpdate.setSupervisor(updateEmployeeInput.supervisor());
        }
        Employee employeeUpdated = employeeService.update(employeeToUpdate);
        return new ResponseEntity<>(employeeUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
