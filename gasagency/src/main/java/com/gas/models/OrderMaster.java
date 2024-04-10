package com.gas.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class OrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    private User user;

    private Date orderDateTime;

    private String gasNumber;

    @ManyToOne
    private AddressMaster addressMaster;

    private Date deliveryDate;

    @ManyToOne
    private GasAgencyMaster gasAgencyMaster;

    private String manifestedStatus;

    private String pickedUpStatus;

    private String transitStatus;

    private String finalStatus;

    private String currentStatus;
}
