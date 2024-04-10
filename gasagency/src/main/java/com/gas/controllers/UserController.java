package com.gas.controllers;

import com.gas.models.User;
import com.gas.payloads.request.LoginRequest;
import com.gas.payloads.request.UserRequest;
import com.gas.payloads.response.LoginResponse;
import com.gas.payloads.response.MainResponse;
import com.gas.payloads.response.UserResponse;
import com.gas.repositories.RoleRepository;
import com.gas.repositories.UserRepository;
import com.gas.services.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserRequest userRequest){
        UserResponse userResponse = this.userService.create(userRequest);

        if (userResponse!=null){
            return new ResponseEntity(userResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(userResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        MainResponse  mainResponse = new MainResponse();
        LoginResponse loginResponse = new LoginResponse();
        User user = this.userRepository.findByMobileNumber(loginRequest.getMobileNumber());
        if (user!=null){
            if(user.getMobileNumber().equalsIgnoreCase(loginRequest.getMobileNumber())){
                if (user.getPassword().equalsIgnoreCase(loginRequest.getPassword())){
//                    loginResponse.setUserId(user.getUserId());
//                    loginResponse.setEmail(user.getEmail());
//                    loginResponse.setFirstName(user.getFirstName());
//                    loginResponse.setLastName(user.getLastName());
//                    loginResponse.setEmail(user.getEmail());
//                    loginResponse.setMobileNumber(user.getMobileNumber());
//                    loginResponse.setStatus(user.getStatus());
//                    loginResponse.setMessage("Login successfully");
//                    loginResponse.setResponseCode(HttpStatus.OK.value());
//                    loginResponse.setFlag(true);

                    BeanUtils.copyProperties(user,loginResponse);
                    loginResponse.setUserId(user.getUserId());
                    loginResponse.setMessage("Login successfully");
                    loginResponse.setResponseCode(HttpStatus.OK.value());
                    loginResponse.setFlag(true);

                    return new ResponseEntity(loginResponse, HttpStatus.OK);
                }else {
                    mainResponse.setMessage("Invalid password");
                    mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
                    mainResponse.setFlag(false);
                    return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
                }
            }else {
                mainResponse.setMessage("User doesn't exists");
                mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
                mainResponse.setFlag(false);
                return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
            }
        }else {
            mainResponse.setMessage("user not exists");
            mainResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            mainResponse.setFlag(false);
            return new ResponseEntity(mainResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody UserRequest userRequest){
        UserResponse userResponse = this.userService.update(userRequest);

        if (userResponse!=null){
            return new ResponseEntity(userResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(userResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbyid/{userId}")
    public ResponseEntity getByUserId(@PathVariable("userId") Integer userId){
        UserResponse userResponse = this.userService.getById(userId);

        if(userResponse!=null){
            return new ResponseEntity(userResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity(userResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        List<UserResponse>  userResponses = this.userService.getAllUsers();

        if(userResponses!=null){
            return new ResponseEntity(userResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(userResponses, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallactive")
    public ResponseEntity getAllActive(){
        List<UserResponse>  userResponses = this.userService.getAllActiveUsers();

        if(userResponses!=null){
            return new ResponseEntity(userResponses, HttpStatus.OK);
        }else {
            return new ResponseEntity(userResponses, HttpStatus.BAD_REQUEST);
        }
    }
}
