package com.example.jpatest.business.employee.create.dto;

import com.example.jpatest.constants.EmployeeRole;
import com.example.jpatest.database.entity.Address;
import com.example.jpatest.database.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
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
    private Address address;
}
