package com.bookings.main.repository;

import com.bookings.main.dto.Hotel;
import com.bookings.main.dto.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query("SELECT i.hotel from Inventory i where i.hotel.city= :city AND i.date= :date AND i.availableRooms>0")
    List<Hotel> findHotelsForGivenDateAndCity(@Param("date") LocalDate date, @Param("city") String city);

    @Query("SELECT i from Inventory i where i.hotel.name= :hotelName AND i.hotel.city= :city AND i.date= :date")
    Optional<Inventory> findHotelInventoryForGivenDateCityAndHotel(@Param("hotelName") String hotelName, @Param("city") String city,
                                                                   @Param("date") LocalDate date);
}
