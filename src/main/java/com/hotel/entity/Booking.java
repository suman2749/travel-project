package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_id", nullable = false)
    private String bookingId;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "check_in_date", nullable = false)
    private Date checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private Date checkOutDate;

    @Column(name = "total_amount", nullable = false)
    private Float totalAmount;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @ManyToOne
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "hotel_hotel_id")
    private Hotel hotel;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Payment payment;

}