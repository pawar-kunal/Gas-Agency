package com.gas.controllers;

import com.gas.payloads.request.RoleRequest;
import com.gas.payloads.response.MainResponse;
import com.gas.payloads.response.RoleResponse;
import com.gas.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody RoleRequest roleRequest){
        MainResponse mainResponse = this.roleService.create(roleRequest);

        if (mainResponse!=null){
            return new ResponseEntity(mainResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RoleRequest roleRequest){
        MainResponse mainResponse = this.roleService.update(roleRequest);

        if (mainResponse!=null){
            return new ResponseEntity(mainResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyid/{roleId}")
    public ResponseEntity getById(@PathVariable("roleId") Integer roleId){
        RoleResponse roleResponse = this.roleService.getById(roleId);

        if (roleResponse!=null){
            return new ResponseEntity(roleResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(roleResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        List<RoleResponse> roleResponses = this.roleService.getAll();

        if (roleResponses!=null){
            return new ResponseEntity(roleResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(roleResponses, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallactive")
    public ResponseEntity getAllActive(){
        List<RoleResponse> roleResponses = this.roleService.getAllActive();

        if (roleResponses!=null){
            return new ResponseEntity(roleResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(roleResponses, HttpStatus.BAD_REQUEST);
        }
    }
}
