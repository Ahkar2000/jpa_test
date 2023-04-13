package com.example.jpatest.business.employee.inquiry;

import com.example.jpatest.BaseResponse;

public interface InquiryEmployeeIf {
    public BaseResponse getEmployee();

    public BaseResponse getEmployeeById(Long id);
}
