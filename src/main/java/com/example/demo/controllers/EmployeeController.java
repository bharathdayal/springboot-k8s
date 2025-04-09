package com.example.demo.controllers;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private DepartmentRepository departmentRepository;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, @RequestParam Long departmentId){
        System.out.println("EMPLOYEE NAME===>"+employee);
        Employee saveEmployee = employeeService.createEmployee(employee,departmentId);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }


    @GetMapping(value="deptname")
    public ResponseEntity<List<Employee>> findByDepartmentName(@RequestParam String departmentName) {
        List<Employee> emp= employeeService.findByDepartmentDeptName(departmentName);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

}
