package com.gas.services;

import com.gas.payloads.request.GasAgencyRequest;
import com.gas.payloads.response.GasAgencyResponse;

import java.util.List;

public interface GasAgencyService {
    Boolean create(GasAgencyRequest gasAgencyRequest);

    Boolean update(GasAgencyRequest gasAgencyRequest);

    GasAgencyResponse getById(Integer gasAgencyId);

    List<GasAgencyResponse> getAll();

    List<GasAgencyResponse> getAllActive();
}
