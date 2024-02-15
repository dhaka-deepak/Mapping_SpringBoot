package com.deepak.mappingspringboot.controller;

import com.deepak.mappingspringboot.entity.Address;
import com.deepak.mappingspringboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addRepository;

    @GetMapping("/getAddress")
    public List<Address> getEmployees(){
        return addRepository.findAll();
    }

}
