package com.deepak.oneToOneBidirectional.controller;

import com.deepak.oneToOneBidirectional.entity.Address;
import com.deepak.oneToOneBidirectional.repository.AddressRepository;
import com.deepak.oneToOneBidirectional.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addRepo;

    @PostMapping("/saveAllData")
    public ResponseEntity<String> saveAllData(@RequestBody List<Address> addresses) {
        addRepo.saveAll(addresses);
        return ResponseEntity.ok("All data (Employees and Addresses) saved");
    }

    @GetMapping("/getAddress")
    public List<Address> getAddresses(){
        return addRepo.findAll();
    }

    @GetMapping("/getAddressById/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> employee = addRepo.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody Address updatedEmployee) {
        if (addRepo.existsById(id)) {
            updatedEmployee.setAddressId(id);
            addRepo.save(updatedEmployee);
            return ResponseEntity.ok("Address updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteAllAddress")
    public ResponseEntity<String> deleteAllAddress() {
        addRepo.deleteAll();
        return ResponseEntity.ok("All Data Deleted");
    }

    @DeleteMapping("/deleteAddressById/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
        Optional<Address> employee = addRepo.findById(id);
        if (employee.isPresent()) {
            addRepo.deleteById(id);
            return ResponseEntity.ok("Address deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
