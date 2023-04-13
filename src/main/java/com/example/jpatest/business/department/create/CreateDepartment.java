package com.example.jpatest.business.department.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;
import com.example.jpatest.database.entity.Department;
import com.example.jpatest.database.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CreateDepartment extends BaseBusiness implements CreateDepartmentIf {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public BaseResponse saveDepartment(DepartmentRequest departmentRequest) {
        if(checkDepartmentName(departmentRequest.getDepartmentName(),null)){
            throw new IllegalStateException("Department Name already exists.");
        }
        Department department = new Department(departmentRequest.getDepartmentName());
        departmentRepository.save(department);
        return generateDefaultResponse(department);
    }
}
