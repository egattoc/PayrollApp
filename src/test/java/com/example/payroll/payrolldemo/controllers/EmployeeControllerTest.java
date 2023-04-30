package com.example.payroll.payrolldemo.controllers;

import com.example.payroll.payrolldemo.entities.Employee;
import com.example.payroll.payrolldemo.entities.dtos.EmployeeDto;
import com.example.payroll.payrolldemo.requests.UpdateEmployeeInput;
import com.example.payroll.payrolldemo.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeControllerTest {
    private final EmployeeService employeeService = Mockito.mock(EmployeeService.class);

    private EmployeeController employeeController;

    private static final String name = "Adam";

    private static final String address = "Address";

    private static final Employee employee = new Employee(1,"Adam", "SWE", 200, "SFO", "Sales", "Anushka");
    private static final EmployeeDto employeeDto = new EmployeeDto("Adam", "SWE", 200, "SFO", "Sales", "Anushka");

    private static final UpdateEmployeeInput updateEmployeeInput = new UpdateEmployeeInput("Adam", "SWE", 200, "SFO", "Sales", "Anushka");
    private static final Employee employee2 = new Employee(1,"Adam", "SWE", 200, "SFO", "Sales", "Anu");
    @BeforeEach
    public void setup() {
        employeeController = new EmployeeController(employeeService);
        Mockito.when(employeeService.findAll()).thenReturn(Collections.singletonList(employee));
    }

    @Test
    public void testFindAll_ExpectSuccess() {
        final ResponseEntity<List<Employee>> expectedEmployees =
                new ResponseEntity<>(Collections.singletonList(employee), HttpStatus.OK);
        final ResponseEntity<List<Employee>> employees = employeeController.allEmployees();
        Assertions.assertEquals(expectedEmployees, employees);
    }

    @Test
    public void testFindById_ExpectSuccess(){
        final Optional<Employee> optionalEmployee = Optional.of(employee);
        Mockito.when(employeeService.findById(1)).thenReturn(optionalEmployee);
        final ResponseEntity<Employee> expectedEmployee =
                new ResponseEntity<>(employee, HttpStatus.OK);
        final ResponseEntity<Employee> actualEmployee = employeeController.oneEmployee(1);
        Assertions.assertEquals(expectedEmployee, actualEmployee);

    }

    @Test
    public void testFindById_ExpectFailure(){
        final Optional<Employee> optionalEmployee = Optional.empty();
        Mockito.when(employeeService.findById(2)).thenReturn(optionalEmployee);
        final ResponseEntity<Employee> expectedEmployee =
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        final ResponseEntity<Employee> actualEmployee = employeeController.oneEmployee(2);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void testCreate_ExpectSuccess(){
        Mockito.when(employeeService.create(Mockito.any(Employee.class))).thenReturn(employee);
//        final ResponseEntity<Employee> expectedEmployee =
//                new ResponseEntity<>(employee,HttpStatus.CREATED);
        final ResponseEntity<Employee> actualOutput = employeeController.createEmployee(employeeDto);
        Assertions.assertEquals(HttpStatus.CREATED,actualOutput.getStatusCode());
        final Employee actualEmployee = actualOutput.getBody();
        Assertions.assertEquals(employee.getName(), actualEmployee.getName());
        Assertions.assertEquals(employee.getAddress(), actualEmployee.getAddress());
        Assertions.assertEquals(employee.getDepartment(), actualEmployee.getDepartment());
        Assertions.assertEquals(employee.getPosition(), actualEmployee.getPosition());
        Assertions.assertEquals(employee.getSupervisor(), actualEmployee.getSupervisor());
        Assertions.assertEquals(employee.getSalary(), actualEmployee.getSalary());
    }

    @Test
    public void testUpdate_ExpectFailure(){
        final Optional<Employee> optionalEmployee = Optional.empty();
        Mockito.when(employeeService.findById(1)).thenReturn(optionalEmployee);
        final ResponseEntity<Employee> expectedEmployee =
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        final ResponseEntity<Employee> actualEmployee = employeeController.updateEmployee(1, updateEmployeeInput);
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

//    @Test
//    public void testUpdate_ExpectSuccess() {
//        final Optional<Employee> optionalEmployee = Optional.of(employee);
//        Mockito.when(employeeService.findById(2)).thenReturn(optionalEmployee);
//        Mockito.when(employeeService.update(employee)).thenReturn(employee2);
//        final ResponseEntity<Employee> expectedEmployee =
//                new ResponseEntity<>(employee, HttpStatus.OK);
//        final ResponseEntity<Employee> actualEmployee = employeeController.updateEmployee(2, new UpdateEmployeeInput("Adam", "SWE", 200, "SFO", "Sales", "Anu"));
//        Assertions.assertEquals(expectedEmployee, actualEmployee);
//    }

}
