package com.hotel.payload;

import com.hotel.entity.Customer;
import com.hotel.entity.Hotel;
import com.hotel.entity.Payment;
import com.hotel.entity.Room;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Date;
@Data
public class BookingDTO {
    private String bookingId;
    private Date bookingDate;
    private Date checkInDate;
    private Date checkOutDate;
    private Float totalAmount;
    private String bookingStatus;
    private Customer customer;


    private Room room;
    private Hotel hotel;
    private Payment payment;

}
