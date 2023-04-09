package com.example.jpatest.business.address.update;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.address.create.dto.AddressRequest;

public interface UpdateAddressIf {
    public BaseResponse deleteAddress(Long id);

    public BaseResponse updateAddress(Long id, AddressRequest addressRequest);
}
