package com.example.jpatest.business.department.create.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    @NotBlank
    @NotNull
    private String departmentName;
}
