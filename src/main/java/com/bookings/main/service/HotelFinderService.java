package com.bookings.main.service;

import com.bookings.main.dao.*;
import com.bookings.main.dto.Hotel;
import com.bookings.main.repository.HotelRespository;
import com.bookings.main.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelFinderService {
    IHotelDao hotelDao;
    IInventoryDao inventoryDao;

    public HotelFinderService(HotelRespository hotelRespository, InventoryRepository inventoryRepository) {
        this.hotelDao = new HotelDaoH2Impl(hotelRespository);
        this.inventoryDao = new InventoryDaoImpl(inventoryRepository);
    }

    public List<Hotel> findAllHotelsByCity(String city) {
        return hotelDao.findHotelsByCity(city);
    }

    public List<Hotel> findAllHotelsByCityAndBudget(String city, float budget) {
        return hotelDao.listHotelsWithinBudgetForCity(budget, city);
    }

    public List<Hotel> findHotelsForGivenDateAndCity(LocalDate date, String city) {
        return inventoryDao.findHotelsForGivenDateAndCity(date, city);
    }
}
