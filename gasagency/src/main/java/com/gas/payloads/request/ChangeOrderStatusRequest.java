package com.gas.payloads.request;

import lombok.Data;

@Data
public class ChangeOrderStatusRequest {

    private Integer orderId;

    private String currentStatus;
}
