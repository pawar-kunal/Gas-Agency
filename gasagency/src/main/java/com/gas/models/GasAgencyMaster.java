package com.gas.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GasAgencyMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gasAgencyId;

    private String agencyName;

    private String agencyAddress;

    private String agencyMobileNumber;

    private String agencyEmail;

    private Double gasPrize;

    private Double deliveryCharges;

    private Double totalPayableAmount;

    private String status;


}
