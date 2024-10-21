package com.SbTest.SpringBootLearning.Service;

import com.SbTest.SpringBootLearning.Entity.Addresses;
import com.SbTest.SpringBootLearning.Repository.MySqlRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private MySqlRepository mySqlRepository;

    public List<Addresses> getAllAddresses(){
        return mySqlRepository.findAll();
    }

    public Addresses saveAddresses(Addresses addresses){
        return mySqlRepository.save(addresses);
    }
}
