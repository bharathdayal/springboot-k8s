package com.example.demo.services;

import com.example.demo.model.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    List<Department> getAllDepartment();

    void deleteDepartment(Long deptId);
}
