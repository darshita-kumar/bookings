package com.bookings.main.controller;

import com.bookings.main.dto.Room;
import com.bookings.main.repository.RoomRepository;
import com.bookings.main.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("viewRoom/")
@Slf4j
public class RoomViewController {

    RoomService roomService;

    public RoomViewController(RoomRepository roomRepository) {
        this.roomService = new RoomService(roomRepository);
    }

    @GetMapping("view")
    public ResponseEntity<List<Room>> findRoomsForHotelForDate(@RequestParam("hotelName") String hotelName,
                                                               @RequestParam("date") String date) {
        try {
            List<Room> availableRooms = roomService.findRoomsForHotelByDate(hotelName, LocalDate.parse(date));
            return new ResponseEntity<>(availableRooms, HttpStatus.OK);
        }
        catch (Exception ex) {
            log.info("Error occured while fetching available rooms");
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
