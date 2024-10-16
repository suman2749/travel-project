package com.hotel.payload;

import com.hotel.entity.Customer;
import com.hotel.entity.Hotel;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ReviewDTO {

    private String reviewId;
    private String rating;
    private String comment;
    private LocalDate reviewDate;



    private Customer customer;
    private Hotel hotel;
}
