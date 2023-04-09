package com.example.jpatest.business.department.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;

public interface UpdateDepartmentIf {
    public BaseResponse deleteDepartment(Long id);
    public BaseResponse updateDepartment(Long id, DepartmentRequest departmentRequest);
}
