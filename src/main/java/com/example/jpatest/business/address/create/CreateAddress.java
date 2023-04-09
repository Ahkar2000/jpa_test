package com.example.jpatest.business.address.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.address.AddressService;
import com.example.jpatest.business.address.create.dto.AddressRequest;
import com.example.jpatest.database.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateAddress extends BaseBusiness implements CreateAddressIf{
    @Autowired
    AddressService addressService;
    public BaseResponse saveAddress(AddressRequest addressRequest){
        Address address = (Address) changeAddressRequest(addressRequest);
        addressService.saveAddress(address);
        return generateDefaultResponse(address);
    };
}
