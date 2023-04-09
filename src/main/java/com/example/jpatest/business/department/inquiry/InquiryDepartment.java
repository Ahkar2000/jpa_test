package com.example.jpatest.business.department.inquiry;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.department.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InquiryDepartment extends BaseBusiness implements InquiryDepartmentIf{
    @Autowired
    DepartmentService departmentService;
    @Override
    public BaseResponse getDepartment() {
        return generateDefaultResponse(departmentService.getDepartment());
    }
}
