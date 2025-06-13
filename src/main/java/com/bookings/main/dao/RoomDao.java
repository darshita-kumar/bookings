package com.bookings.main.dao;

import com.bookings.main.dto.Room;
import com.bookings.main.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;

public class RoomDao {
    RoomRepository roomRepository;

    public RoomDao(RoomRepository repository) {
        this.roomRepository = repository;
    }

    public List<Room> findRoomsForHotelByDate(String hotelName, LocalDate date) {
        return roomRepository.findRoomsForHotelByDate(hotelName, date);
    }
}
