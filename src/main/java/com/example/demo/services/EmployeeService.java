package com.example.springboot_latest.service;

import com.example.springboot_latest.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee,Long departmentId);

    List<Employee> findByDepartmentDeptName(String departmentName);
}
