package com.hotel.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hotel.entity.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    @Value("${jwt.algorithm.key}")
    public String algorithmKey;
    @Value("${jwt.issuer}")
    public String issuer;
    @Value("${jwt.expiry.duration}")
    private Long expiry;

    private Algorithm algorithm;

    @PostConstruct
    public void postConstruct(){
       algorithm = Algorithm.HMAC256(algorithmKey);
    }
    public String generateToken(Customer customer){
      return  JWT.create()
                .withClaim("username",customer.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiry))
                .withIssuer(issuer)
                .sign(algorithm);
    }

}
