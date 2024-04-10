package com.gas.services.impl;

import com.gas.models.GasAgencyMaster;
import com.gas.models.User;
import com.gas.payloads.request.GasAgencyRequest;
import com.gas.payloads.response.GasAgencyResponse;
import com.gas.repositories.AddressRepository;
import com.gas.repositories.GasAgencyRepository;
import com.gas.repositories.UserRepository;
import com.gas.services.GasAgencyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasAgencyServiceImpl implements GasAgencyService {
    @Autowired
    private GasAgencyRepository gasAgencyRepository;

    @Override
    public Boolean create(GasAgencyRequest gasAgencyRequest) {
        GasAgencyMaster gasAgencyMaster = new GasAgencyMaster();
        BeanUtils.copyProperties(gasAgencyRequest,gasAgencyMaster);
        try {
            this.gasAgencyRepository.save(gasAgencyMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(GasAgencyRequest gasAgencyRequest) {
        GasAgencyMaster gasAgencyMaster = this.gasAgencyRepository.findById(gasAgencyRequest.getGasAgencyId()).get();
        try {
            this.gasAgencyRepository.save(gasAgencyMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GasAgencyResponse getById(Integer gasAgencyId) {
        GasAgencyResponse gasAgencyResponse = this.gasAgencyRepository.getByAgencyId(gasAgencyId);

        if (gasAgencyResponse!=null){
            return gasAgencyResponse;
        }else {
            return new GasAgencyResponse(null,null,null,null,null,null,null);
        }
    }

    @Override
    public List<GasAgencyResponse> getAll() {
        List<GasAgencyResponse> gasAgencyResponses = this.gasAgencyRepository.getAll();
        return gasAgencyResponses;
    }

    @Override
    public List<GasAgencyResponse> getAllActive() {
        List<GasAgencyResponse> gasAgencyResponses = this.gasAgencyRepository.getAllActive("Active");
        return gasAgencyResponses;
    }
}
