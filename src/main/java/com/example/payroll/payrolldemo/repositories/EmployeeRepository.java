package com.example.payroll.payrolldemo.repositories;

import com.example.payroll.payrolldemo.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
