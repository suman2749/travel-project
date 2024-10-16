package com.hotel.controller;

import com.hotel.payload.CustomerDTO;
import com.hotel.payload.JWTTokenDetails;
import com.hotel.payload.SignInDTO;
import com.hotel.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/registration")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity<CustomerDTO>userRegistration(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDto =customerService.registration(customerDTO);
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?>signIn(@RequestBody SignInDTO signInDTO){
        String token = customerService.signin(signInDTO);
        JWTTokenDetails jwtTokenDetails = new JWTTokenDetails();
        jwtTokenDetails.setTokenType("JWT_Token :");
        jwtTokenDetails.setToken(token);
        if(token != null){
           // signInDTO.setMessage("Sign in Successfully");
            return new ResponseEntity<>(jwtTokenDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid credentials",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
