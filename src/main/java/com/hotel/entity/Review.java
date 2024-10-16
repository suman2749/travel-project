package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "reviewId", nullable = false)
    private String reviewId;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date")
    private LocalDate reviewDate;


    @ManyToOne
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hotel_hotel_id")
    private Hotel hotel;

}