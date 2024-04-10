package com.gas.services.impl;

import com.gas.models.AddressMaster;
import com.gas.models.OrderMaster;
import com.gas.models.User;
import com.gas.payloads.request.OrderRequest;
import com.gas.payloads.response.OrderResponse;
import com.gas.repositories.AddressRepository;
import com.gas.repositories.OrderRepository;
import com.gas.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();
        OrderMaster orderMaster = new OrderMaster();
        User user = this.orderRepository.findByMobileNumber(orderRequest.getMobileNumber());
        AddressMaster addressMaster = this.addressRepository.findById(orderRequest.getAddressId()).get();

        if (user==null){
            orderResponse.setMessage("User not exist");
            orderResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            orderResponse.setFlag(false);
            return orderResponse;
        }else {
            BeanUtils.copyProperties(orderRequest,orderMaster);
            orderMaster.setOrderDateTime(new Date());
            orderMaster.setAddressMaster(addressMaster);
            orderMaster.setCurrentStatus("Pending");
            orderMaster.setFinalStatus(orderMaster.getCurrentStatus());
            orderMaster.setUser(user);
            orderMaster.setAddressMaster(addressMaster);
            OrderMaster orderMaster1 = this.orderRepository.save(orderMaster);
            BeanUtils.copyProperties(orderMaster1,orderResponse);
            orderResponse.setOrderId(orderMaster1.getOrderId());
            orderResponse.setUserId(orderMaster1.getUser().getUserId());
            orderResponse.setAddress(orderMaster1.getAddressMaster().getAddress());
            orderResponse.setCity(orderMaster1.getAddressMaster().getCity());
            orderResponse.setCountry(orderMaster1.getAddressMaster().getCountry());
            orderResponse.setState(orderMaster1.getAddressMaster().getState());
            orderResponse.setMessage("Order Successfully");
            orderResponse.setResponseCode(HttpStatus.OK.value());
            orderResponse.setFlag(true);
            return orderResponse;
        }
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public OrderResponse getOrderByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public List<OrderResponse> getAll() {
        return null;
    }

    @Override
    public List<OrderResponse> getAllActive() {
        return null;
    }
}
