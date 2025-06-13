package com.bookings.main.dto;

import com.bookings.main.dto.Hotel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;
    private int availableRooms;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Room> rooms;
}