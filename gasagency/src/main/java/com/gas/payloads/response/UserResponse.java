package com.gas.payloads.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
    private String status;
    private Integer roleId;
}

//um.userId,um.firstName,um.lastName,um.email,um.mobileNumber,um.password,um.status,um.roleId