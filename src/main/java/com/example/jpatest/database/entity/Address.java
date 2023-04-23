package com.example.jpatest.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "street_name",nullable = false)
    private String streetName;

    @Column(name = "house_number",nullable = false)
    private String houseNumber;

    @Column(name = "city_name",nullable = false)
    private String cityName;

    public Address(String streetName, String houseNumber, String cityName) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
    }
}
