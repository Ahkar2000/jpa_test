package com.example.jpatest.business.employee.create.dto;

import com.example.jpatest.constants.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
    @NotNull
    @Min(1)
    private Long addressId;

    @NotNull
    @Min(1)
    private Long departmentId;
}
