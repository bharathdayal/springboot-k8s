package com.example.springboot_latest.repository;

import com.example.springboot_latest.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
