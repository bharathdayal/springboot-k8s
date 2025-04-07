package com.example.springboot_latest.repository;

import com.example.springboot_latest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long> {

     List<Employee> findByDepartmentDeptName(String departmentName);

}
