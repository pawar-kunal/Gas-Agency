package com.gas.payloads.response;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponse {

    private Integer userId;

    private Integer orderId;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String gasNumber;

    private String address;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private Date orderDateTime;

    private Date deliveryDate;

    private String manifestedStatus;

    private String pickedUpStatus;

    private String transitStatus;

    private String finalStatus;

    private String currentStatus;

    private String message;

    private Integer responseCode;

    private Boolean flag;

    public OrderResponse(String message, Integer responseCode, Boolean flag) {
        this.message = message;
        this.responseCode = responseCode;
        this.flag = flag;
    }
}
