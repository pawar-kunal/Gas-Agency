package com.gas.payloads.request;

import lombok.Data;

@Data
public class GasAgencyRequest {
    private Integer gasAgencyId;

    private String agencyName;

    private String agencyAddress;

    private String agencyMobileNumber;

    private String agencyEmail;

    private Double gasPrize;

    private Double deliveryCharges;

    private Double totalPayableAmount;
}
