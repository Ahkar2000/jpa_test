package com.example.jpatest.business.address.create;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.address.create.dto.AddressRequest;

public interface CreateAddressIf {
    public BaseResponse saveAddress(AddressRequest addressRequest);
}
