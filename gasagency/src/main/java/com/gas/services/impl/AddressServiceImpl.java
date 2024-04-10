package com.gas.services.impl;

import com.gas.models.AddressMaster;
import com.gas.models.User;
import com.gas.payloads.request.AddressRequest;
import com.gas.payloads.response.AddressResponse;
import com.gas.repositories.AddressRepository;
import com.gas.repositories.UserRepository;
import com.gas.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddressResponse create(AddressRequest addressRequest) {
        AddressResponse addressResponse = new AddressResponse();
        AddressMaster addressMaster = new AddressMaster();
        BeanUtils.copyProperties(addressRequest,addressMaster);
        User user = this.userRepository.findById(addressRequest.getUserId()).get();
        try {
            addressMaster.setUser(user);
            AddressMaster addressMaster1 = this.addressRepository.save(addressMaster);
            BeanUtils.copyProperties(addressMaster1,addressResponse);
            addressResponse.setUserId(addressMaster1.getUser().getUserId());
            return addressResponse;
        }catch (Exception e){
            e.printStackTrace();
            return addressResponse;
        }
    }

    @Override
    public AddressResponse update(AddressRequest addressRequest) {
        AddressResponse addressResponse = new AddressResponse();
        AddressMaster addressMaster = this.addressRepository.findById(addressRequest.getAddressId()).get();
        BeanUtils.copyProperties(addressMaster,addressRequest);
        User  user = this.userRepository.findById(addressRequest.getUserId()).get();
        try {
            addressMaster.setUser(user);
            AddressMaster addressMaster1 = this.addressRepository.save(addressMaster);
            BeanUtils.copyProperties(addressMaster1,addressResponse);
            addressResponse.setUserId(addressMaster1.getUser().getUserId());
            return addressResponse;
        }catch (Exception e){
            e.printStackTrace();
            return new AddressResponse(null,null,null,null,null,null,null,null,null);
        }
    }

    @Override
    public AddressResponse getById(Integer addressId) {
        AddressResponse addressResponse = this.addressRepository.getAddressByAddressId(addressId);

        if (addressResponse!=null){
            return addressResponse;
        }else {
            return new AddressResponse(null,null,null,null,null,null,null,null,null);
        }
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        List<AddressResponse> addressResponses = this.addressRepository.getAllAddresses();
        return addressResponses;
    }

    @Override
    public List<AddressResponse> getAllActiveAddresses() {
        List<AddressResponse> addressResponses = this.addressRepository.getAllActiveAddresses("Active");
        return addressResponses;
    }
}
