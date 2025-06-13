package com.bookings.main.dao;

import com.bookings.main.dto.Hotel;
import com.bookings.main.dto.Inventory;
import com.bookings.main.repository.InventoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryDaoImpl implements IInventoryDao {
    InventoryRepository inventoryRepository;

    public InventoryDaoImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Hotel> findHotelsForGivenDateAndCity(LocalDate date, String city) {
        List<Hotel> hotelsList = new ArrayList<>();
        try {
            hotelsList = inventoryRepository.findHotelsForGivenDateAndCity(date, city);
        } catch (Exception ex) {
            System.out.println("Error while querying db for findHotelsForGivenDateAndCity");
        }
        return hotelsList;
    }

    @Override
    public Inventory findHotelInventoryForGivenDateCityAndHotel(String hotelName, String city, LocalDate date) {
        Optional<Inventory> inventory = inventoryRepository.findHotelInventoryForGivenDateCityAndHotel(hotelName, city, date);
        if(inventory.isEmpty())
            return null;
        return inventory.get();
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
