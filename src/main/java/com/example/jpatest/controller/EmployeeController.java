package com.example.jpatest.controller;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.employee.create.CreateEmployee;
import com.example.jpatest.business.employee.create.dto.EmployeeRequest;
import com.example.jpatest.business.employee.inquiry.InquiryEmployee;
import com.example.jpatest.business.employee.update.UpdateEmployee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"api/employee"})
public class EmployeeController {

    public EmployeeController(InquiryEmployee inquiryEmployee, CreateEmployee createEmployee, UpdateEmployee updateEmployee) {
        this.inquiryEmployee = inquiryEmployee;
        this.createEmployee = createEmployee;
        this.updateEmployee = updateEmployee;
    }

    private final InquiryEmployee inquiryEmployee;
    private final CreateEmployee createEmployee;
    private final UpdateEmployee updateEmployee;

    @GetMapping
    public ResponseEntity<BaseResponse> getEmployee(){
        return ResponseEntity.ok(inquiryEmployee.getEmployee());
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> saveEmployee(@Valid @RequestBody EmployeeRequest employee){
        return ResponseEntity.ok(createEmployee.saveEmployee(employee));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BaseResponse> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeRequest employee){
        return ResponseEntity.ok(updateEmployee.updateEmployee(id,employee));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<BaseResponse> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(updateEmployee.deleteEmployee(id));
    }
}
