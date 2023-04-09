package com.example.jpatest.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.jpatest.BaseResponse;
import com.example.jpatest.business.address.create.CreateAddress;
import com.example.jpatest.business.address.create.dto.AddressRequest;
import com.example.jpatest.business.address.inquiry.InquiryAddress;
import com.example.jpatest.business.address.update.UpdateAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/api/address"})
public class AddressController {

    private final InquiryAddress inquiryAddress;
    private final CreateAddress createAddress;
    private final UpdateAddress updateAddress;

    public AddressController(InquiryAddress inquiryAddress, CreateAddress createAddress, UpdateAddress updateAddress) {
        this.inquiryAddress = inquiryAddress;
        this.createAddress = createAddress;
        this.updateAddress = updateAddress;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAddress(){
        return ResponseEntity.ok(inquiryAddress.getAddress());
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> saveAddress(@Valid @RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(createAddress.saveAddress(addressRequest));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<BaseResponse> deleteAddress(@PathVariable Long id){
        return ResponseEntity.ok(updateAddress.deleteAddress(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BaseResponse> updateAddress(@PathVariable Long id,@RequestBody AddressRequest addressRequest){
        return ResponseEntity.ok(updateAddress.updateAddress(id,addressRequest));
    }
}
