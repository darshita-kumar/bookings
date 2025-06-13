package com.bookings.main.dao;

import com.bookings.main.dto.Hotel;
import com.bookings.main.dto.Inventory;

import java.time.LocalDate;
import java.util.List;

public interface IInventoryDao {
    List<Hotel> findHotelsForGivenDateAndCity(LocalDate date, String city);

    Inventory findHotelInventoryForGivenDateCityAndHotel(String hotelName, String city, LocalDate date);

    void updateInventory(Inventory inventory);
}
