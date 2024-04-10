package com.gas.services.impl;

import com.gas.models.RoleMaster;
import com.gas.payloads.request.RoleRequest;
import com.gas.payloads.response.MainResponse;
import com.gas.payloads.response.RoleResponse;
import com.gas.repositories.RoleRepository;
import com.gas.services.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public MainResponse create(RoleRequest roleRequest) {
        RoleMaster roleMaster = new RoleMaster();
        MainResponse mainResponse = new MainResponse();
        BeanUtils.copyProperties(roleRequest,roleMaster);
        try {
            roleMaster.setDate(new Date());
            this.roleRepository.save(roleMaster);
            mainResponse.setMessage("Role Created");
            mainResponse.setResponseCode(HttpStatus.OK.value());
            mainResponse.setFlag(true);
            return mainResponse;
        }catch (Exception e){
            e.printStackTrace();
            mainResponse.setMessage("Role not create");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
            return mainResponse;
        }
    }

    @Override
    public MainResponse update(RoleRequest roleRequest) {
        RoleMaster roleMaster = this.roleRepository.findById(roleRequest.getRoleId()).get();
        MainResponse mainResponse = new MainResponse();
        BeanUtils.copyProperties(roleRequest,roleMaster);
        try {
            roleMaster.setDate(new Date());
            this.roleRepository.save(roleMaster);
            mainResponse.setMessage("Role updated");
            mainResponse.setResponseCode(HttpStatus.OK.value());
            mainResponse.setFlag(true);
            return mainResponse;
        }catch (Exception e){
            e.printStackTrace();
            mainResponse.setMessage("Role doesn't update");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
            return mainResponse;
        }
    }

    @Override
    public RoleResponse getById(Integer roleId) {
        RoleResponse roleResponse = this.roleRepository.getByRoleId(roleId);
        if (roleResponse!=null){
            return roleResponse;
        }else {
            return new RoleResponse(null,null,null,null);
        }
    }

    @Override
    public List<RoleResponse> getAll() {
        List<RoleResponse> roleResponses = this.roleRepository.getAll();
        return roleResponses;
    }

    @Override
    public List<RoleResponse> getAllActive() {
        List<RoleResponse> roleResponses = this.roleRepository.getAllActive("Active");
        return roleResponses;
    }
}
