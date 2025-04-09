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

import java.util.List;

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

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDept(@PathVariable ("id") Long deptId,
                                        @RequestBody Department department) {

        department.setId(deptId);
        Department updateDept = departmentService.updateDepartment(department);
        return new ResponseEntity<>(updateDept,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDept(){
        List<Department> dept = departmentService.getAllDepartment();
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDept(@PathVariable("id") Long deptInd) {
         departmentService.deleteDepartment(deptInd);
        return new ResponseEntity<>("Department successfully deleted!", HttpStatus.OK);
    }
}
