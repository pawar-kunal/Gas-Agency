package com.gas.payloads.response;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleResponse {
    private Integer roleId;

    private String roleName;

    private Date date;

    private String status;
}
