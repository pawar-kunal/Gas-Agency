package com.gas.repositories;

import com.gas.models.RoleMaster;
import com.gas.payloads.response.RoleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleMaster, Integer> {
    @Query("select new com.gas.payloads.response.RoleResponse(rm.roleId,rm.roleName,rm.date,rm.status)from RoleMaster as rm where rm.roleId=:roleId")
    RoleResponse getByRoleId(@Param("roleId") Integer roleId);

    @Query("select new com.gas.payloads.response.RoleResponse(rm.roleId,rm.roleName,rm.date,rm.status)from RoleMaster as rm ")
    List<RoleResponse> getAll();
    @Query("select new com.gas.payloads.response.RoleResponse(rm.roleId,rm.roleName,rm.date,rm.status)from RoleMaster as rm where rm.status='Active'")
    List<RoleResponse> getAllActive(String active);
}
