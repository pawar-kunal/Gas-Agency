package com.gas.services;

import com.gas.payloads.request.LoginRequest;
import com.gas.payloads.request.UserRequest;
import com.gas.payloads.response.LoginResponse;
import com.gas.payloads.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    UserResponse update(UserRequest userRequest);

    UserResponse getById(Integer userId);

    List<UserResponse> getAllUsers();

    List<UserResponse> getAllActiveUsers();

}
