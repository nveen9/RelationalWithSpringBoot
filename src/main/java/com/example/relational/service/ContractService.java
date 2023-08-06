package com.example.relational.service;

import com.example.relational.entity.Contract;
import com.example.relational.entity.Room;
import com.example.relational.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    // C
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    // R
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    // R by ID
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    // U
    public Contract updateContract(Long id, Contract updatedContract) {
        Contract existingContract = contractRepository.findById(id).orElse(null);
        if (existingContract != null) {
            existingContract.setHotelName(updatedContract.getHotelName());
            existingContract.setStartDate(updatedContract.getStartDate());
            existingContract.setEndDate(updatedContract.getEndDate());
            existingContract.setRate(updatedContract.getRate());

            // Update the RoomType entities
            List<Room> updatedRoomTypes = updatedContract.getRoom();
            for (int i = 0; i < updatedRoomTypes.size(); i++) {
                Room updatedRoomType = updatedRoomTypes.get(i);
                Room existingRoomType = existingContract.getRoom().get(i);
                existingRoomType.setRoomType(updatedRoomType.getRoomType());
                existingRoomType.setMaxAdults(updatedRoomType.getMaxAdults());
                existingRoomType.setPrice(updatedRoomType.getPrice());
                existingRoomType.setAvailableRooms(updatedRoomType.getAvailableRooms());
            }
            return contractRepository.save(existingContract);
        } else {
            return null;
        }
    }

    // D
    public boolean deleteContract(Long id) {
        Contract existingContract = contractRepository.findById(id).orElse(null);
        if (existingContract != null) {
            contractRepository.delete(existingContract);
            return true;
        } else {
            return false;
        }
    }
}
