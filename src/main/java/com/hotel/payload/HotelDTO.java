package com.hotel.payload;

import com.hotel.entity.Booking;
import com.hotel.entity.Review;
import com.hotel.entity.Room;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
public class HotelDTO {
    private String hotelId;
    private String name;
    private String address;
    private String city;
    private String country;
    private Float rating;
    private String description;


    private Set<Room> rooms = new LinkedHashSet<>();
    private Set<Review> reviews = new LinkedHashSet<>();
    private Set<Booking> bookings = new LinkedHashSet<>();
}
