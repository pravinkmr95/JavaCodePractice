package com.SbTest.SpringBootLearning.Controller;

import com.SbTest.SpringBootLearning.Entity.Addresses;
import com.SbTest.SpringBootLearning.Repository.MySqlRepository;
import com.SbTest.SpringBootLearning.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class StoreController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list-addresses")
    public List<Addresses> getAddresses(){
        return addressService.getAllAddresses();
    }

    @PostMapping
    public Addresses createAddress(@RequestBody Addresses addresses){
        return addressService.saveAddresses(addresses);
    }

}
