package com.gas.payloads.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String mobileNumber;

    private String password;
}
