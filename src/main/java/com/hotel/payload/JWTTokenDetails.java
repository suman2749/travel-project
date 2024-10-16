package com.hotel.payload;

import lombok.Data;

@Data
public class JWTTokenDetails {
    private String token;
    private String tokenType;
}
