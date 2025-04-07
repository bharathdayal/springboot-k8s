package com.example.springboot_latest.service;

import com.example.springboot_latest.model.Department;
import com.example.springboot_latest.model.Employee;
import com.example.springboot_latest.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor


public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    private EntityManager entityManager;

    @Transactional
    public Employee createEmployee(Employee employee,Long departmentId) {
        addEmployeeDept(employee,departmentId);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void addEmployeeDept(Employee employee,Long departmentId) {
            Department department = entityManager.find(Department.class,departmentId);
            System.out.println("DEPARTMENT===> "+department.getDeptName());
            employee.setDepartment(department);
            entityManager.persist(employee);
    }


    @Override
    public List<Employee> findByDepartmentDeptName(String departmentName) {
        return employeeRepository.findByDepartmentDeptName(departmentName);
    }
}
