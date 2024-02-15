package com.deepak.manyToOneBidirectional.Controller;

import com.deepak.manyToOneBidirectional.Entity.Address;
import com.deepak.manyToOneBidirectional.Entity.Employee;
import com.deepak.manyToOneBidirectional.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/getAddresses")
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
}
