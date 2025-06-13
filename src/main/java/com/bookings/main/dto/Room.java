package com.bookings.main.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
    @Id
    int roomId;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    RoomType roomType;

    float pricePerNight;
    int availableRooms;
    int allowedGuests;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Inventory inventory;
}
