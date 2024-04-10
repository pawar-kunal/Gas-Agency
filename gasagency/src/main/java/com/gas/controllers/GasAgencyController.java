package com.gas.controllers;

import com.gas.payloads.request.GasAgencyRequest;
import com.gas.payloads.response.GasAgencyResponse;
import com.gas.services.impl.GasAgencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gasagency")
@CrossOrigin(origins = "*")
public class GasAgencyController {
    @Autowired
    private GasAgencyServiceImpl gasAgencyService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody GasAgencyRequest gasAgencyRequest){
        Boolean flag = this.gasAgencyService.create(gasAgencyRequest);

        if (Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity(flag, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody GasAgencyRequest gasAgencyRequest){
        Boolean flag = this.gasAgencyService.update(gasAgencyRequest);

        if (Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity(flag, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyid/{gasAgencyId}")
    public ResponseEntity getById(@PathVariable("gasAgencyId") Integer gasAgencyId){
        GasAgencyResponse gasAgencyResponse = this.gasAgencyService.getById(gasAgencyId);

        if (gasAgencyResponse!=null){
            return new ResponseEntity(gasAgencyResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(gasAgencyResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        List<GasAgencyResponse> gasAgencyResponses = this.gasAgencyService.getAll();

        if (gasAgencyResponses!=null){
            return new ResponseEntity(gasAgencyResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(gasAgencyResponses, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallactive")
    public ResponseEntity getAllActive(){
        List<GasAgencyResponse> gasAgencyResponses = this.gasAgencyService.getAllActive();

        if (gasAgencyResponses!=null){
            return new ResponseEntity(gasAgencyResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(gasAgencyResponses, HttpStatus.BAD_REQUEST);
        }
    }
}
