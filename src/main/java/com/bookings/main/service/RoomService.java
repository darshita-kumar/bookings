package com.bookings.main.service;

import com.bookings.main.dao.RoomDao;
import com.bookings.main.dto.Room;
import com.bookings.main.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {
    RoomDao roomDao;

    public RoomService(RoomRepository roomRepository) {
        this.roomDao = new RoomDao(roomRepository);
    }

    public List<Room> findRoomsForHotelByDate(String hotelName, LocalDate date) {
        return roomDao.findRoomsForHotelByDate(hotelName, date);
    }
}
