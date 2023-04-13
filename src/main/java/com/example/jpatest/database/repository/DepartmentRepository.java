package com.example.jpatest.database.repository;

import com.example.jpatest.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findDepartmentByDepartmentName (String departmentName);
}
