package com.bookings.main.dao;

import com.bookings.main.dto.Hotel;

import java.util.List;

public interface IHotelDao {
    List<Hotel> findHotelsByCity(String city);
    List<Hotel> listHotelsWithinBudgetForCity(float budget, String city);
}
