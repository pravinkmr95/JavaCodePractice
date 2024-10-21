package com.practice.order.Contoller;

import com.practice.order.Entity.Customer;
import com.practice.order.Entity.OrderEntry;
import com.practice.order.Service.CustomerService;
import com.practice.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "customers")
    public ResponseEntity<Page<Customer>> getAllCustomers(@RequestParam(defaultValue = "0") int start,
                                                          @RequestParam(defaultValue = "2") int size,
                                                          @RequestParam String sortBy){
        Page<Customer> customerList = customerService.getCustomersPaginated(start, size, sortBy);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(required = true) Long id){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()){
            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name){
        List<Customer> customers = customerService.getCustomersByName(name);
        if (!customers.isEmpty()){
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer customer1 = customerService.saveCustomer(customer);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(required = true) Long id){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()){
            List<OrderEntry> orderEntryList = orderService.getOrdersByCustomer(id);
            orderEntryList.forEach((orderEntry -> {
                orderService.deleteOrderById(orderEntry.getOrder_id());
            }));
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> putCustomer(@PathVariable Long id, @RequestBody Customer newCustomer){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()){
            Customer oldCustomer = customerOptional.get();
            oldCustomer.setName(newCustomer.getName());
            customerService.saveCustomer(oldCustomer);
            return new ResponseEntity<>(oldCustomer, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Customer> patchCustomer(@PathVariable Long id, @RequestBody Map<String, Object> customerMap){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent()){
            Customer oldCustomer = customerOptional.get();
            oldCustomer.setName((String) customerMap.get("name"));
            customerService.saveCustomer(oldCustomer);
            return new ResponseEntity<>(oldCustomer, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
