package com.gas.payloads.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GasAgencyResponse {
    private Integer gasAgencyId;

    private String agencyName;

    private String agencyAddress;

    private String agencyMobileNumber;

    private String agencyEmail;

    private Double gasPrize;

    private Double deliveryCharges;
}


//    ag.gasAgencyId,ag.agencyName,ag.agencyAddress,ag.agencyMobileNumber,ag.agencyEmail,ag.gasPrize,ag.deliveryCharges