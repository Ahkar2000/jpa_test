package com.example.jpatest.business.employee.inquiry;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.employee.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InquiryEmployee extends BaseBusiness implements InquiryEmployeeIf{
    @Autowired
    EmployeeService employeeService;

    @Override
    public BaseResponse getEmployee(){
        return generateDefaultResponse(employeeService.getEmployee());
    }
}
