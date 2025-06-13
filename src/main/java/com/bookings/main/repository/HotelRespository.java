package com.bookings.main.repository;

import com.bookings.main.dto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRespository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByName(String name);
    List<Hotel> findByCity(String city);

    @Query("Select c from Hotel c where c.pricePerNight<:budget and c.city = :city")
    List<Hotel> listHotelsWithinBudgetForCity(@Param("budget") float budget,
                                              @Param("city") String city);
}
