package com.gas.payloads.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
    private String status;
    private String message;
    private Integer responseCode;
    private Boolean flag;
}
