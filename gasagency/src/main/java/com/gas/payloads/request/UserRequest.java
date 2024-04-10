package com.gas.payloads.request;

import lombok.Data;

@Data
public class UserRequest {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
    private String status;
    private Integer roleId;
}
