package com.example.jpatest.database.entity;

import com.example.jpatest.constants.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private EmployeeRole role;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee(String name, String email, LocalDate birthDate, EmployeeRole role,Address address) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.role = role;
        this.address = address;
    }
}
