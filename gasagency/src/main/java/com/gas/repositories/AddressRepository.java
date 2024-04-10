package com.gas.repositories;

import com.gas.models.AddressMaster;
import com.gas.payloads.response.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressMaster,Integer> {
    @Query("select new com.gas.payloads.response.AddressResponse(am.addressId,am.name,am.address,am.zipCode,am.city,am.state,am.country,am.status,am.user.userId) from AddressMaster as am where am.addressId=:addressId and am.status='Active'")
    AddressResponse getAddressByAddressId(@Param("addressId") Integer addressId);

    @Query("select new com.gas.payloads.response.AddressResponse(am.addressId,am.name,am.address,am.zipCode,am.city,am.state,am.country,am.status,am.user.userId) from AddressMaster as am ")
    List<AddressResponse> getAllAddresses();

    @Query("select new com.gas.payloads.response.AddressResponse(am.addressId,am.name,am.address,am.zipCode,am.city,am.state,am.country,am.status,am.user.userId) from AddressMaster as am where am.status='Active'")
    List<AddressResponse> getAllActiveAddresses(String active);
}
