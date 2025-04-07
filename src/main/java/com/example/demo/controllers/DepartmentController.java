package com.example.springboot_latest.controller;

import com.example.springboot_latest.model.Department;
import com.example.springboot_latest.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dept")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Department> createDept(@RequestBody Department department) {
        Department department1 = departmentService.createDepartment(department);

        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }
}
