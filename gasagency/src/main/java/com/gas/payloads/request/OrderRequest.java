package com.gas.payloads.request;

import lombok.Data;
@Data
public class OrderRequest {

    private Integer orderId;

    private String mobileNumber;

    private String gasNumber;

    private Integer addressId;
}
