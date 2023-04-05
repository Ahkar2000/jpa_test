package com.example.jpatest.controller;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.employee.inquiry.InquiryEmployee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = {"api/v1/employee"})
public class EmployeeController {

    public EmployeeController(InquiryEmployee inquiryEmployee) {
        this.inquiryEmployee = inquiryEmployee;
    }

    private final InquiryEmployee inquiryEmployee;

    @GetMapping
    public ResponseEntity<BaseResponse> getEmployee(){
        return ResponseEntity.ok(inquiryEmployee.getEmployee());
    }

}
