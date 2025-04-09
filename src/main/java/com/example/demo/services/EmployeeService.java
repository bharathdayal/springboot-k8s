package com.example.demo.services;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee,Long departmentId);

    List<Employee> findByDepartmentDeptName(String departmentName);
}
