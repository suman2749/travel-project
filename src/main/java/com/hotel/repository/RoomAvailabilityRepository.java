package com.hotel.repository;

import com.hotel.entity.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, String> {
}