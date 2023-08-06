package com.example.relational.controller;

import com.example.relational.entity.Contract;
import com.example.relational.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    // C
    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract createdContract = contractService.createContract(contract);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContract);
    }

    // R
    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    // R by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Contract contract = contractService.getContractById(id);
        if (contract != null) {
            return ResponseEntity.ok(contract);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // U
    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract updatedContract) {
        Contract contract = contractService.updateContract(id, updatedContract);
        if (contract != null) {
            return ResponseEntity.ok(contract);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // D
    @DeleteMapping("/{id}")
    public String deleteContract(@PathVariable Long id) {
        boolean deleted = contractService.deleteContract(id);
        if (deleted) {
            ResponseEntity.noContent().build();
            return "Contract " + id + "Deleted";
        } else {
            ResponseEntity.notFound().build();
            return "Fails";
        }
    }

    // Search by hotel name and booking date
    @GetMapping("/search")
    public ResponseEntity<Object> searchContracts(@RequestBody Map<String, String> request) {
        String hotelName = request.get("hotelName");
        Date date = Date.valueOf(request.get("bookingDate"));
        List<Contract> contracts = contractService.searchContracts(hotelName, date);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(contracts);
        }
    }
}
