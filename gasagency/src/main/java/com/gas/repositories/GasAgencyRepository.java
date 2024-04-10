package com.gas.repositories;

import com.gas.models.GasAgencyMaster;
import com.gas.payloads.response.GasAgencyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasAgencyRepository extends JpaRepository<GasAgencyMaster,Integer> {
    @Query("select new com.gas.payloads.response.GasAgencyResponse(ag.gasAgencyId,ag.agencyName,ag.agencyAddress,ag.agencyMobileNumber,ag.agencyEmail,ag.gasPrize,ag.deliveryCharges) from GasAgencyMaster as ag where ag.gasAgencyId=:gasAgencyId ")
    GasAgencyResponse getByAgencyId(@Param("gasAgencyId") Integer gasAgencyId);

    @Query("select new com.gas.payloads.response.GasAgencyResponse(ag.gasAgencyId,ag.agencyName,ag.agencyAddress,ag.agencyMobileNumber,ag.agencyEmail,ag.gasPrize,ag.deliveryCharges) from GasAgencyMaster as ag ")
    List<GasAgencyResponse> getAll();
    @Query("select new com.gas.payloads.response.GasAgencyResponse(ag.gasAgencyId,ag.agencyName,ag.agencyAddress,ag.agencyMobileNumber,ag.agencyEmail,ag.gasPrize,ag.deliveryCharges) from GasAgencyMaster as ag where ag.status='Active'")
    List<GasAgencyResponse> getAllActive(String Active);
}
