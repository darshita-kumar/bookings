package com.bookings.main.repository;

import com.bookings.main.dto.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Query("SELECT i from Room i where i.inventory.id= :inventoryId")
    public List<Room> findRoomsByInventoryId(@Param("inventoryId") long inventoryId);

    @Query("SELECT r FROM Room r JOIN r.inventory i JOIN i.hotel h WHERE h.name= :hotelName AND i.date= :date AND r.availableRooms>0")
    public List<Room> findRoomsForHotelByDate(@Param("hotelName") String hotelName, @Param("date") LocalDate date);

//    SELECT r.* FROM room r
//    JOIN inventory i ON r.inventory_id = i.id
//    JOIN hotel h ON i.hotel_id = h.id
//    WHERE h.name = 'Radisson Blu' AND i.date = '2025-06-10';
}
