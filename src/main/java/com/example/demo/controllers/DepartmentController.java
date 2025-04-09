package com.example.demo.controllers;

import com.example.demo.model.Department;
import com.example.demo.services.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dept")
@RequiredArgsConstructor
public class DepartmentController {


    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Department> createDept(@RequestBody Department department) {
        Department department1 = departmentService.createDepartment(department);

        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }
}
