package com.example.relational.controller;

import com.example.relational.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;
}
