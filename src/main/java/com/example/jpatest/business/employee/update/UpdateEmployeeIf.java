package com.example.jpatest.business.employee.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;

public interface UpdateEmployeeIf {
    public BaseResponse updateEmployee(Long id,EmployeeRequest employeeRequest);
    public BaseResponse deleteEmployee(Long id);
}
