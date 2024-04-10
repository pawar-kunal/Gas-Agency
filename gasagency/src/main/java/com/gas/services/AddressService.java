package com.gas.services;

import com.gas.payloads.request.AddressRequest;
import com.gas.payloads.response.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse create(AddressRequest addressRequest);

    AddressResponse update(AddressRequest addressRequest);

    AddressResponse getById(Integer addressId);

    List<AddressResponse> getAllAddresses();

    List<AddressResponse> getAllActiveAddresses();
}
