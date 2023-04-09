package com.example.jpatest.business.address;

import com.example.jpatest.business.address.create.dto.AddressRequest;
import com.example.jpatest.database.entity.Address;

import java.util.List;

public interface AddressServiceIf {
    public List<Address> getAddress();
    public Address saveAddress(Address address);

    public void deleteAddress(Long id);
}
