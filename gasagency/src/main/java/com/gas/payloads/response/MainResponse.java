package com.gas.payloads.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainResponse {

    private String message;

    private Integer responseCode;

    private Boolean flag;
}
