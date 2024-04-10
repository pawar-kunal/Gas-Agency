package com.gas.payloads.request;

import lombok.Data;

@Data
public class RoleRequest {
    private Integer roleId;

    private String roleName;

    private String status;
}
