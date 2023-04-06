package com.example.jpatest.business.employee.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;

public interface CreateEmployeeIf {
    public BaseResponse saveEmployee(EmployeeRequest employeeRequest);

}
