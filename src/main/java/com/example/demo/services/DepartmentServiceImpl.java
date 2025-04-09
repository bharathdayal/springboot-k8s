package com.example.springboot_latest.service;

import com.example.demo.model.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
