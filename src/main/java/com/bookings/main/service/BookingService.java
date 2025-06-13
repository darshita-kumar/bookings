package com.bookings.main.service;

import com.bookings.main.dto.BookingResponseDto;
import com.bookings.main.dto.Inventory;
import com.bookings.main.dao.InventoryDaoImpl;
import com.bookings.main.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
//@RequiredArgsConstructor
public class BookingService {
    InventoryDaoImpl inventoryDao;

    public BookingService(InventoryRepository inventoryRepository) {
        this.inventoryDao = new InventoryDaoImpl(inventoryRepository);
    }

    @Transactional
    public BookingResponseDto bookHotelForCityDateAndGuests(String city, LocalDate date, int guests, String hotelName) {
        Inventory iv = inventoryDao.findHotelInventoryForGivenDateCityAndHotel(hotelName, city, date);
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setBooked(false);
        if(iv == null) {
            bookingResponseDto.setMessage("Hotel not found or has been booked by other customers");
        }
        else if(iv.getAvailableRooms() < guests) {
            bookingResponseDto.setMessage("Not enough rooms for all guests");
        } else {
            iv.setAvailableRooms(iv.getAvailableRooms()-guests);
            inventoryDao.updateInventory(iv);
            bookingResponseDto.setBooked(true);
            bookingResponseDto.setHotelName(hotelName);
            bookingResponseDto.setMessage("Booked hotel");
        }
        return bookingResponseDto;
    }
}
