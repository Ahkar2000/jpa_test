package com.example.jpatest.business.department.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;

public interface CreateDepartmentIf {
    public BaseResponse saveDepartment(DepartmentRequest departmentRequest);
}
