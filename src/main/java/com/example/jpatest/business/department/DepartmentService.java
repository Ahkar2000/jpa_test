package com.example.jpatest.business.department;

import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.database.entity.Department;
import com.example.jpatest.database.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService extends BaseBusiness implements DepartmentServiceIf {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
