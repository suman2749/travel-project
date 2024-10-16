package com.hotel.service.impl;

import com.hotel.entity.Customer;
import com.hotel.exception.UserExistsException;
import com.hotel.payload.CustomerDTO;
import com.hotel.payload.SignInDTO;
import com.hotel.repository.CustomerRepository;
import com.hotel.service.CustomerService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
   private CustomerRepository customerRepository;
   private JWTService jwtService;

    public CustomerServiceImpl(CustomerRepository customerRepository, JWTService jwtService) {
        this.customerRepository = customerRepository;
        this.jwtService = jwtService;
    }
//-----------------------------User Signup-------------------------------------------
    @Override
    public CustomerDTO registration(CustomerDTO customerDTO) {
        Optional<Customer> byUsername = customerRepository.findByUsername(customerDTO.getUsername());
        if(byUsername.isPresent()){
            throw new UserExistsException("User already exists with this username ");
        }

        Optional<Customer>byEmail = customerRepository.findByEmail(customerDTO.getEmail());
        if(byEmail.isPresent()){
            throw new UserExistsException("User already exists with this email");
        }

        Optional<Customer> byPhone =customerRepository.findByPhone(customerDTO.getPhone());
        if(byPhone.isPresent()){
            throw new UserExistsException("user already exists with this phone");
        }



        String hashpw = BCrypt.hashpw(customerDTO.getPassword(), BCrypt.gensalt(12));
        customerDTO.setPassword(hashpw);

        Customer customer = mapToEntity(customerDTO);
        String customerId = UUID.randomUUID().toString();
        customer.setCustomerId(customerId);

        Customer saveCustomer = customerRepository.save(customer);
        CustomerDTO dto =mapToDTO(saveCustomer);
        return dto;
    }

    @Override
    public String signin(SignInDTO signInDTO) {
        Optional<Customer> byEmailOrUsername = customerRepository.findByEmailOrUsername(signInDTO.getEmail(), signInDTO.getUsername());
        if (byEmailOrUsername.isPresent()) {
            Customer customer = byEmailOrUsername.get();
           if(BCrypt.checkpw(signInDTO.getPassword(), customer.getPassword())){
               signInDTO.setPassword(customer.getPassword());
               return jwtService.generateToken(customer);
           }else{
               return "Invalid credentials";
           }


        }
        return null;
    }
    //---------------------------------------------------------------------------------------------------
    Customer mapToEntity(CustomerDTO customerDTO){
        Customer entity = new Customer();
        entity.setName(customerDTO.getName());
        entity.setAddress(customerDTO.getAddress());
        entity.setEmail(customerDTO.getEmail());
        entity.setPhone(customerDTO.getPhone());
        entity.setUsername(customerDTO.getUsername());
        entity.setPassword(customerDTO.getPassword());
        return entity;
    }
    CustomerDTO mapToDTO (Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setName(customer.getName());
        dto.setAddress(customer.getAddress());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setUsername(customer.getUsername());
        dto.setPassword(customer.getPassword());
        return dto;
    }

}
