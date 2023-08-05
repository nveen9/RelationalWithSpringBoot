package com.example.relational.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String roomType;
    private int maxAdults;
    private int price;
    private int availableRooms;
}
