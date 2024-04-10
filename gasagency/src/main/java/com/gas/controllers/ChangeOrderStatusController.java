package com.gas.controllers;

import com.gas.models.OrderMaster;
import com.gas.models.User;
import com.gas.payloads.request.ChangeOrderStatusRequest;
import com.gas.payloads.response.OrderResponse;
import com.gas.repositories.OrderRepository;
import com.gas.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/chageorderstatus")
@CrossOrigin(origins = "*")
public class ChangeOrderStatusController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/changestatus")
    public ResponseEntity create(@RequestBody ChangeOrderStatusRequest changeOrderStatusRequest){
        OrderResponse orderResponse = new OrderResponse();
        OrderMaster orderMaster = this.orderRepository.findById(changeOrderStatusRequest.getOrderId()).get();
        User user = this.userRepository.findById(orderMaster.getUser().getUserId()).get();

        String roleName = user.getRoleMaster().getRoleName();

        if (roleName.equalsIgnoreCase("Admin")) {

            BeanUtils.copyProperties(changeOrderStatusRequest, orderMaster);

            if (orderMaster != null) {
                Date orderAcceptedDate = new Date();
                Integer days=2;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(orderAcceptedDate);
                calendar.add(Calendar.DAY_OF_YEAR,days);
                Date deliveryDate = calendar.getTime();

                System.out.println("Original Date: " + orderAcceptedDate);
                System.out.println("Date after "+days+" days: " + deliveryDate);

                orderMaster.setUser(user);
                orderMaster.setDeliveryDate(deliveryDate);
                orderMaster.setCurrentStatus(changeOrderStatusRequest.getCurrentStatus());
                orderMaster.setFinalStatus(orderMaster.getCurrentStatus());
                OrderMaster orderMaster1 = this.orderRepository.save(orderMaster);
                BeanUtils.copyProperties(orderMaster1, orderResponse);
                orderResponse.setUserId(orderMaster1.getUser().getUserId());
                orderResponse.setOrderId(orderMaster1.getOrderId());
                orderResponse.setDeliveryDate(orderMaster1.getDeliveryDate());
                orderResponse.setFirstName(orderMaster1.getUser().getFirstName());
                orderResponse.setLastName(orderMaster1.getUser().getLastName());
                orderResponse.setMobileNumber(orderMaster1.getUser().getMobileNumber());
                orderResponse.setAddress(orderMaster1.getAddressMaster().getAddress());
                orderResponse.setCountry(orderMaster1.getAddressMaster().getCountry());
                orderResponse.setState(orderMaster1.getAddressMaster().getState());
                orderResponse.setCity(orderMaster1.getAddressMaster().getCity());
                orderResponse.setZipCode(orderMaster1.getAddressMaster().getZipCode());
                orderResponse.setFinalStatus(orderMaster1.getFinalStatus());
                orderResponse.setMessage("Admin Accepted your Order at " + orderAcceptedDate+" and your gas delivery Date is "+orderMaster1.getDeliveryDate());
                orderResponse.setResponseCode(HttpStatus.OK.value());
                orderResponse.setFlag(true);
                return new ResponseEntity(orderResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity(orderResponse, HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity(orderResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
