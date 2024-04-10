package com.gas.services.impl;

import com.gas.models.RoleMaster;
import com.gas.models.User;
import com.gas.payloads.request.UserRequest;
import com.gas.payloads.response.UserResponse;
import com.gas.repositories.RoleRepository;
import com.gas.repositories.UserRepository;
import com.gas.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        UserResponse userResponse = new UserResponse();
        Integer roleId = userRequest.getRoleId();

        RoleMaster roleMaster = this.roleRepository.findById(userRequest.getRoleId()).get();

        if (roleMaster==null){
            roleMaster = this.roleRepository.findById(2).get();
        }

        BeanUtils.copyProperties(userRequest,user);
        try {
            user.setRoleMaster(roleMaster);
            user.setDate(new Date());
            User user1 = this.userRepository.save(user);
            BeanUtils.copyProperties(user1,userResponse);
            userResponse.setUserId(user1.getUserId());
            userResponse.setRoleId(user1.getUserId());
            return userResponse;
        }catch (Exception e){
            e.printStackTrace();
            return new UserResponse(null,null,null,null,null,null,null,null);
        }
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        User user = this.userRepository.findById(userRequest.getUserId()).get();
        RoleMaster roleMaster = this.roleRepository.findById(userRequest.getRoleId()).get();
        BeanUtils.copyProperties(userRequest,user);

        if (roleMaster==null){
            roleMaster = this.roleRepository.findById(2).get();
        }

        try {
            user.setRoleMaster(roleMaster);
            user.setDate(new Date());
            User user1 = this.userRepository.save(user);
            BeanUtils.copyProperties(user1,userResponse);
            userResponse.setUserId(user1.getUserId());
            userResponse.setRoleId(user1.getUserId());
            return userResponse;
        }catch (Exception e){
            e.printStackTrace();
            return new UserResponse(null,null,null,null,null,null,null,null);
        }
    }

    @Override
    public UserResponse getById(Integer userId) {
        UserResponse userResponse = this.userRepository.getByUserId(userId);

        if (userResponse!=null){
            return userResponse;
        }else {
            return new UserResponse(null,null,null,null,null,null,null,null);
        }
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponses = this.userRepository.getAll();
        return userResponses;
    }

    @Override
    public List<UserResponse> getAllActiveUsers() {
        List<UserResponse> userResponses = this.userRepository.getAllActive("Active");
        return userResponses;
    }

}
