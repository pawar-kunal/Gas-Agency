package com.gas.repositories;

import com.gas.models.OrderMaster;
import com.gas.models.User;
import com.gas.payloads.request.ChangeOrderStatusRequest;
import com.gas.payloads.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderMaster, Integer> {
    @Query("select um from User as um where um.mobileNumber=:mobileNumber")
    User findByMobileNumber(@Param("mobileNumber") String mobileNumber);

}
