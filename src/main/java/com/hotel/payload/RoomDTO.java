package com.hotel.payload;

import com.hotel.entity.Booking;
import com.hotel.entity.Hotel;
import com.hotel.entity.RoomAvailability;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Data
public class RoomDTO {

    private String roomId;
    private String roomType;
    private Float price;
    private String capacity;
    private Boolean availabilityStatus;
    private Hotel hotel;


    private Set<Booking> bookings = new LinkedHashSet<>();
    private List<RoomAvailability> roomAvailabilities = new ArrayList<>();

}
