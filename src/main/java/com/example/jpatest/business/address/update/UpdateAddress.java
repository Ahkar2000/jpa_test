package com.example.jpatest.business.address.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.address.AddressService;
import com.example.jpatest.business.address.create.dto.AddressRequest;
import com.example.jpatest.database.entity.Address;
import com.example.jpatest.database.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UpdateAddress extends BaseBusiness implements UpdateAddressIf {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;
    @Override
    public BaseResponse deleteAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if(!address.isPresent()){
            throw new IllegalStateException("Address does not exist.");
        }
        addressService.deleteAddress(id);
        return generateDefaultResponse("Address is deleted.");
    }

    @Override
    public BaseResponse updateAddress(Long id, AddressRequest addressRequest) {
        Optional<Address> exists = addressRepository.findById(id);
        if(!exists.isPresent()){
            throw new IllegalStateException("Address does not exist.");
        }
        Address address = exists.get();
        address.setCityName(addressRequest.getCityName());
        address.setHouseNumber(addressRequest.getHouseNumber());
        address.setStreetName(addressRequest.getStreetName());
        address = addressService.saveAddress(address);
        return generateDefaultResponse(address);
    }
}
