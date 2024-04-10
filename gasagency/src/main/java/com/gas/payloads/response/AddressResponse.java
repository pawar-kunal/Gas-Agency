package com.gas.payloads.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
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

