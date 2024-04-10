package com.gas.services;

import com.gas.models.RoleMaster;
import com.gas.payloads.request.RoleRequest;
import com.gas.payloads.response.MainResponse;
import com.gas.payloads.response.RoleResponse;

import java.util.List;

public interface RoleService {
    MainResponse create(RoleRequest roleRequest);

    MainResponse update(RoleRequest roleRequest);

    RoleResponse getById(Integer roleId);

    List<RoleResponse> getAll();

    List<RoleResponse> getAllActive();
}
