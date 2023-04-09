package com.example.jpatest.business.address;

import com.example.jpatest.database.entity.Address;
import com.example.jpatest.database.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AddressServiceIf{
    @Autowired
    AddressRepository addressRepository;
    @Override
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }


}
