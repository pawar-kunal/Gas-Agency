package com.gas.repositories;

import com.gas.models.User;
import com.gas.payloads.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select um from User as um where um.mobileNumber=:mobileNumber")
    User findByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("select new com.gas.payloads.response.UserResponse(um.userId,um.firstName,um.lastName,um.email,um.mobileNumber,um.password,um.status,um.roleMaster.roleId) from User as um where um.userId=:userId")
    UserResponse getByUserId(@Param("userId") Integer userId);

    @Query("select new com.gas.payloads.response.UserResponse(um.userId,um.firstName,um.lastName,um.email,um.mobileNumber,um.password,um.status,um.roleMaster.roleId) from User as um")
    List<UserResponse> getAll();

    @Query("select new com.gas.payloads.response.UserResponse(um.userId,um.firstName,um.lastName,um.email,um.mobileNumber,um.password,um.status,um.roleMaster.roleId) from User as um where um.status='Active'")
    List<UserResponse> getAllActive(String Active);
}
