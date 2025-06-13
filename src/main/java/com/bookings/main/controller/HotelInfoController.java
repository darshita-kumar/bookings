package com.bookings.main.controller;

import com.bookings.main.dto.Hotel;
import com.bookings.main.service.HotelFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hotelInfo/")
public class HotelInfoController {

    HotelFinderService hotelFinderService;

    public HotelInfoController(HotelFinderService hotelFinderService) {
        this.hotelFinderService = hotelFinderService;
    }

    @GetMapping("search")
    public ResponseEntity<List<Hotel>> getAllHotelsByCity(@RequestParam(name = "city") String city) {
        if(city == null)
            return ResponseEntity.ok(new ArrayList<>());

        List<Hotel> hotels = hotelFinderService.findAllHotelsByCity(city);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("searchWithBudget")
    public ResponseEntity<List<Hotel>> getAllHotelsByCityAndBudget(@RequestParam(name = "city") String city,
                                                                   @RequestParam(name = "budget") float budget) {
        if(city == null)
            return ResponseEntity.ok(new ArrayList<>());

        List<Hotel> hotels = hotelFinderService.findAllHotelsByCityAndBudget(city, budget);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("findHotels")
    public ResponseEntity<List<Hotel>> getHotelsByCityAndDate(@RequestParam("date") String date,
                                                              @RequestParam("city") String city) {
        if(city == null || date == null)
            return ResponseEntity.ok(new ArrayList<>());
        List<Hotel> searchedHotels = hotelFinderService.findHotelsForGivenDateAndCity(LocalDate.parse(date), city);
        return ResponseEntity.ok(searchedHotels);
    }
}
