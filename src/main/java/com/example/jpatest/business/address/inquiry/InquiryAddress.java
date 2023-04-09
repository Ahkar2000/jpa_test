package com.example.jpatest.business.address.inquiry;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.BaseBusiness;
import com.example.jpatest.business.address.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InquiryAddress extends BaseBusiness implements InquiryAddressIf {
    @Autowired
    AddressService addressService;

    @Override
    public BaseResponse getAddress() {
        return generateDefaultResponse(addressService.getAddress());
    }
}
