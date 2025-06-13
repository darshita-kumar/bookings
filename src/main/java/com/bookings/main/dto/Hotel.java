package com.bookings.main.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Hotel {
    @Id
    private Long id;
    private Float rating;
    private String name;
    private String city;
    private Float pricePerNight;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Inventory> inventories;
}
