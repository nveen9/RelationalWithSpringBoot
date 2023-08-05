package com.example.relational.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private int maxAdults;
    private int price;
    private int availableRooms;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
