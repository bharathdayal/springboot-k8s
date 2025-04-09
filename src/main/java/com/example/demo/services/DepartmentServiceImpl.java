package com.example.demo.services;

import com.example.demo.model.Department;
import com.example.demo.model.User;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {

        Department existingDept = departmentRepository.findById(department.getId()).orElseThrow(()-> new RuntimeException("Department not found"));
        existingDept.setDeptName(department.getDeptName());
        return departmentRepository.save(existingDept);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    @Override
    public void deleteDepartment(Long deptId){
        departmentRepository.deleteById(deptId);
    }
}
