package com.example.jpatest.business.department;

import com.example.jpatest.database.entity.Department;

import java.util.List;

public interface DepartmentServiceIf {
    public List<Department> getDepartment();
    public Department saveDepartment(Department department);
    public void deleteDepartment(Long id);
}
