package com.example.payroll.payrolldemo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;
    private String name;
    private String position;
    private double salary;
    private String address;
    private String department;
    private String supervisor;

    private int usedVacationDays = 0;
    private int totalVacationDays = 20;


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getUsedVacationDays() {
        return usedVacationDays;
    }

    public void setUsedVacationDays(int usedVacationDays) {
        this.usedVacationDays = usedVacationDays;
    }

    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(int totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    public Employee(){

    }
    public Employee(int id, String name, String position, double salary, String address, String department, String supervisor) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.address = address;
        this.department = department;
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
