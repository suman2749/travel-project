package com.hotel.payload;

import com.hotel.entity.Room;
import lombok.Data;

import java.sql.Date;
@Data
public class RoomAvailabilityDTO {

    private String availabilityId;
    private Date date;
    private Boolean isAvailable = false;

    private Room room;
}
