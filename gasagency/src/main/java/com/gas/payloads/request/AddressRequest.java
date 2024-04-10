package com.gas.payloads.request;

import lombok.Data;

@Data
public class AddressRequest {

    private Integer addressId;

    private String name;

    private String address;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private String status;

    private Integer userId;
}
