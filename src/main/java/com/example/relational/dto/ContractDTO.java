package com.example.relational.dto;

import com.example.relational.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    private Date startDate;
    private Date endDate;
    private double rate;
    private String hotelName;
    private List<Room> rooms;
}
