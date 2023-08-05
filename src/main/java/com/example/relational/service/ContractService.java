package com.example.relational.service;

import com.example.relational.dto.ContractDTO;
import com.example.relational.dto.RoomDTO;
import com.example.relational.entity.Contract;
import com.example.relational.entity.Hotel;
import com.example.relational.entity.Room;
import com.example.relational.repository.ContractRepository;
import com.example.relational.repository.HotelRepository;
import com.example.relational.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void createContract(String hotelName, Date startDate, Date endDate, Double rate, List<Room> rooms){
        //Hotel
        Hotel hotel = new Hotel();
        hotel.setName(hotelName);

        //Contract
        Contract contract = new Contract();
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);
        contract.setRate(rate);
        contract.setHotel(hotel);

        hotelRepository.save(hotel);
        contractRepository.save(contract);

        //Room
        for (Room room : rooms) {
            room.setHotel(hotel);
        }

        roomRepository.saveAll(rooms);
    }

}
