package com.hotel.service;

import com.hotel.payload.CustomerDTO;
import com.hotel.payload.SignInDTO;

public interface CustomerService {
    public CustomerDTO registration(CustomerDTO customerDTO);
    public String signin(SignInDTO signInDTO);
}
