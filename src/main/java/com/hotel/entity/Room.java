package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "roomId", nullable = false)
    private String roomId;

    @Column(name = "room_type", nullable = false)
    private String roomType;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "capacity", nullable = false)
    private String capacity;

    @Column(name = "availability_status", nullable = false)
    private Boolean availabilityStatus;


    @ManyToOne
    @JoinColumn(name = "hotel_hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "room", orphanRemoval = true)
    private List<RoomAvailability> roomAvailabilities = new ArrayList<>();

}