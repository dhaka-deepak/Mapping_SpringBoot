package com.deepak.oneToManyBidrectional.Controller;

import com.deepak.oneToManyBidrectional.Entity.Address;
import com.deepak.oneToManyBidrectional.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addRepo;

    @GetMapping("/getAddress")
    public List<Address> getAddress(){
        return addRepo.findAll();
    }
}
