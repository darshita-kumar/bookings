package com.bookings.main.dao;

import com.bookings.main.dto.Hotel;
import com.bookings.main.repository.HotelRespository;

import java.util.ArrayList;
import java.util.List;

public class HotelDaoH2Impl implements IHotelDao {

    HotelRespository hotelRespository;

    public HotelDaoH2Impl(HotelRespository hotelRespository) {
        this.hotelRespository = hotelRespository;
    }

    @Override
    public List<Hotel> findHotelsByCity(String city) {
        List<Hotel> hotelList = new ArrayList<>();
        try {
            hotelList = hotelRespository.findByCity(city);
        } catch (Exception ex) {
            System.out.println("Issues while fetching data from db -> findByCity query");
        }
        return  hotelList;
    }

    @Override
    public List<Hotel> listHotelsWithinBudgetForCity(float budget, String city) {
        List<Hotel> hotelList = new ArrayList<>();
        try {
            hotelList = hotelRespository.listHotelsWithinBudgetForCity(budget, city);
        } catch (Exception ex) {
            System.out.println("Issues while fetching data from db -> listHotelsWithinBudgetForCityAndDate query");
        }
        return  hotelList;
    }
}
