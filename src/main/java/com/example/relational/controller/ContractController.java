package com.example.relational.controller;

import com.example.relational.dto.ContractDTO;
import com.example.relational.entity.Contract;
import com.example.relational.entity.Hotel;
import com.example.relational.entity.Room;
import com.example.relational.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping("/")
    public ResponseEntity<String> createContract(@RequestBody ContractDTO contractDTO) {
        // Convert DTO to entities and call the service method
        List<Room> rooms = contractDTO.getRooms();
        contractService.createContract(contractDTO.getHotelName(), contractDTO.getStartDate(),
                contractDTO.getEndDate(), contractDTO.getRate(), rooms);
        return ResponseEntity.ok("Data added successfully.");
    }
}
