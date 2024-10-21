package com.SbTest.SpringBootLearning.Controller;

import com.SbTest.SpringBootLearning.Entity.PaymentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/payments")
public class PaymentController {

//    @GetMapping("hello")
//    public String hello(){
//        return "Hello";
//    }
//
//    @GetMapping("World")
//    public String World(){
//        return "World";
//    }
    private Map<Long, PaymentEntity> paymentEntityMap = new HashMap<>();

    @GetMapping
    public List<PaymentEntity> getAll(){
        System.out.println(paymentEntityMap);
        return new ArrayList<>(paymentEntityMap.values());
    }

    @GetMapping("id/{id}")
    public PaymentEntity findById(@PathVariable Long id){
        return paymentEntityMap.get(id);
    }

    @PostMapping
    public boolean createEntry(@RequestBody PaymentEntity paymentEntity){
        paymentEntityMap.put(paymentEntity.getId(), paymentEntity);
        return true;
    }

    @DeleteMapping("/id/{id}")
    public PaymentEntity deleteById(@PathVariable Long id){
        return paymentEntityMap.remove(id);
    }

    @PutMapping("/id/{id}")
    public PaymentEntity updateById(@PathVariable Long id, @RequestBody PaymentEntity paymentEntity){ //@RequestBody Map<String, String> body
        return paymentEntityMap.put(id, paymentEntity);
    }

}
