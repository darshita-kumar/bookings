package com.bookings.main.controller;

import com.bookings.main.dto.BookingResponseDto;
import com.bookings.main.repository.InventoryRepository;
import com.bookings.main.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("bookHotel")
public class BookingController {
    BookingService bookingService;

    public BookingController(InventoryRepository inventoryRepository) {
        this.bookingService = new BookingService(inventoryRepository);
    }

    @GetMapping("/book")
    public ResponseEntity<BookingResponseDto> bookHotel(@RequestParam("city")String city, @RequestParam("date")String date,
                                                        @RequestParam("guests")int guests, @RequestParam("hotelName")String hotelName) {
        BookingResponseDto bookingResponseDto = bookingService.bookHotelForCityDateAndGuests(city, LocalDate.parse(date), guests, hotelName);
        return new ResponseEntity<>(bookingResponseDto, HttpStatus.OK);
    }
}
