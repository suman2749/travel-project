package com.hotel.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.entity.Booking;
import com.hotel.entity.Review;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
@Data

public class CustomerDTO {

    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;

//    private Set<Review> reviews = new LinkedHashSet<>();
//    private Set<Booking> bookings = new LinkedHashSet<>();
}
