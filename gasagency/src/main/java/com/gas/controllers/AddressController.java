package com.gas.controllers;

import com.gas.payloads.request.AddressRequest;
import com.gas.payloads.response.AddressResponse;
import com.gas.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = this.addressService.create(addressRequest);

        if (addressResponse!=null){
            return new ResponseEntity(addressResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(addressResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(AddressRequest addressRequest){
        AddressResponse addressResponse = this.addressService.update(addressRequest);

        if (addressResponse!=null){
            return new ResponseEntity(addressResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(addressResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyid/{addressId}")
    public ResponseEntity getAddressByAddressId(@PathVariable("addressId") Integer addressId){
        AddressResponse addressResponse = this.addressService.getById(addressId);

        if (addressResponse!=null){
            return new ResponseEntity(addressResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(addressResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        List<AddressResponse> addressResponses = this.addressService.getAllAddresses();

        if (addressResponses!=null){
            return new ResponseEntity(addressResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(addressResponses, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallactive")
    public ResponseEntity getAllActive(){
        List<AddressResponse> addressResponses = this.addressService.getAllActiveAddresses();

        if (addressResponses!=null){
            return new ResponseEntity(addressResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(addressResponses, HttpStatus.BAD_REQUEST);
        }
    }
}
