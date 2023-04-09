package com.example.jpatest.controller;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.department.create.CreateDepartment;
import com.example.jpatest.business.department.create.dto.DepartmentRequest;
import com.example.jpatest.business.department.inquiry.InquiryDepartment;
import com.example.jpatest.business.department.update.UpdateDepartment;
import com.example.jpatest.database.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/department"})
public class DepartmentController {
    private final InquiryDepartment inquiryDepartment;

    public DepartmentController(InquiryDepartment inquiryDepartment, CreateDepartment createDepartment, UpdateDepartment updateDepartment) {
        this.inquiryDepartment = inquiryDepartment;
        this.createDepartment = createDepartment;
        this.updateDepartment = updateDepartment;
    }

    private final CreateDepartment createDepartment;
    private final UpdateDepartment updateDepartment;

    @GetMapping
    public ResponseEntity<BaseResponse> getDepartment(){
        return ResponseEntity.ok(inquiryDepartment.getDepartment());
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
        return ResponseEntity.ok(createDepartment.saveDepartment(departmentRequest));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BaseResponse> saveDepartment(@PathVariable Long id,@RequestBody DepartmentRequest departmentRequest){
        return ResponseEntity.ok(updateDepartment.updateDepartment(id,departmentRequest));
    }

    @DeleteMapping("/{id}/update")
    public ResponseEntity<BaseResponse> saveDepartment(@PathVariable Long id){
        return ResponseEntity.ok(updateDepartment.deleteDepartment(id));
    }
}
