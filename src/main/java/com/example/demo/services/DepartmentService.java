package com.example.demo.services;

import com.example.demo.model.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    Department createDepartment(Department department);
}
