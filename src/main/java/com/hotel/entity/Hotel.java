package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {


    @Id
    @Column(name = "hotelId", nullable = false)
    private String hotelId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hotel", orphanRemoval = true)
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hotel", orphanRemoval = true)
    private Set<Booking> bookings = new LinkedHashSet<>();

}