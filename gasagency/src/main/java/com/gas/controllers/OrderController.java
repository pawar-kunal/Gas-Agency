package com.gas.controllers;

import com.gas.payloads.request.OrderRequest;
import com.gas.payloads.response.OrderResponse;
import com.gas.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = this.orderService.create(orderRequest);
        if (orderResponse!=null){
            return new ResponseEntity(orderResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(orderResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
