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
@Table(name = "room_availability")
public class RoomAvailability {
    @Id
    @Column(name = "availability_Id", nullable = false)
    private String availabilityId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = false;


    @ManyToOne
    @JoinColumn(name = "room_room_id")
    private Room room;

}