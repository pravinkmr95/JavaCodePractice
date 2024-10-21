package com.practice.order.Service;

import com.practice.order.Entity.Customer;
import com.practice.order.Entity.OrderEntry;
import com.practice.order.Repository.CustomerRepository;
import com.practice.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    public List<OrderEntry> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<OrderEntry> getOrdersByCustomer(Long customerId){
        Customer customer = customerService.getCustomerById(customerId).get();
        return orderRepository.findByCustomer(customer);
    }

    public OrderEntry saveOrder(OrderEntry orderEntry){
        return orderRepository.save(orderEntry);
    }

    public Optional<OrderEntry> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

    public Page<OrderEntry> getOrders(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return orderRepository.findAll(pageable);
    }

    public ResponseEntity<OrderEntry> patchOrder(Long id, Map<String, Object> payloadMap){
        Optional<OrderEntry> existingOrderOptional = orderRepository.findById(id);
        if (existingOrderOptional.isPresent()){
            OrderEntry existingOrderEntry = existingOrderOptional.get();
            payloadMap.forEach((key, value) -> {
                switch (key){
                    case "numberOfItems":
                        existingOrderEntry.setNumberOfItems((Integer) value);
                        break;
                    case "details":
                        existingOrderEntry.setDetails((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field " + key);
                }
            });
            orderRepository.save(existingOrderEntry);
            return ResponseEntity.ok(existingOrderEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<OrderEntry> getOrdersByDetails(String orderDetail){
        return orderRepository.findOrderByDetails(orderDetail);
    }

    public List<OrderEntry> getOrdersByNumberOfItems(int numberOfItems){
        return orderRepository.findOrderByNumberOfItems(numberOfItems);
    }

    public List<OrderEntry> findOrdersByDetailsAndNumberOfItems(String details, int numberOfItems){
        return orderRepository.findOrdersByDetailsAndNumberOfItems(details, numberOfItems);
    }


}
