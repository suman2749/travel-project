package com.hotel.repository;

import com.hotel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
   Optional<Customer>findByUsername(String username);
   Optional<Customer> findByEmail(String email);
   Optional<Customer>findByPhone(String phone);

   Optional<Customer>findByEmailOrUsername(String email,String username);
}