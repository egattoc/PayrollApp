package com.example.payroll.payrolldemo.requests;

public record UpdateEmployeeInput(String name, String position, double salary, String address, String department, String supervisor) {
}
