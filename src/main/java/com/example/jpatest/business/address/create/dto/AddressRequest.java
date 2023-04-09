package com.example.jpatest.business.address.create.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank
    private String streetName;

    @NotBlank
    private String houseNumber;

    @NotBlank
    private String cityName;

}
