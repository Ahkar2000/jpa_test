package com.example.jpatest.business.department.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.department.DepartmentService;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;
import com.example.jpatest.database.entity.Department;
import com.example.jpatest.database.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateDepartment extends BaseBusiness implements UpdateDepartmentIf {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public BaseResponse deleteDepartment(Long id) {
        departmentService.deleteDepartment(id);
        return generateDefaultResponse("Department is deleted.");
    }

    @Override
    public BaseResponse updateDepartment(Long id, DepartmentRequest departmentRequest) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("Department does not exist."));
        if(checkDepartmentName(departmentRequest.getDepartmentName(),department.getDepartmentName())){
            throw new IllegalStateException("Department already exists.");
        }
        department.setDepartmentName(departmentRequest.getDepartmentName());
        departmentService.saveDepartment(department);
        return generateDefaultResponse(department);
    }
}
