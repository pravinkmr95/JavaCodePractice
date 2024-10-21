package com.practice.order.Contoller;

import com.practice.order.Entity.OrderEntry;
import com.practice.order.Service.OrderService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order", params = {})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order-list")
    public ResponseEntity<List<OrderEntry>> getAllOrders(){
        List<OrderEntry> orderEntryList = orderService.getAllOrders();
        return ResponseEntity.ok(orderEntryList);
    }

    @GetMapping("orders")
    ResponseEntity<Page<OrderEntry>> getPagedOrders(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "2") int size,
                                    @RequestParam String sortBy){
        Page<OrderEntry> page1 = orderService.getOrders(page, size, sortBy);
        return ResponseEntity.ok(page1);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderEntry>> getOrderByCustomer(@PathVariable Long customerId){
        List<OrderEntry> orderEntryList = orderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orderEntryList);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderEntry> getOrderById(@PathVariable Long id){
        Optional<OrderEntry> orderEntryOptional = orderService.getOrderById(id);
        return orderEntryOptional.map(orderEntry -> new ResponseEntity<>(orderEntry,
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public OrderEntry createOrder(@RequestBody OrderEntry orderEntry){
        try {
            return orderService.saveOrder(orderEntry);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public boolean deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
        return true;
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderEntry> updateOrder(@PathVariable Long id, @RequestBody OrderEntry orderEntry){
        Optional<OrderEntry> existingOrderOptional = orderService.getOrderById(id);
        if (existingOrderOptional.isPresent()) {
            OrderEntry existingOrder = existingOrderOptional.get();
            existingOrder.setDetails(orderEntry.getDetails());
            existingOrder.setNumberOfItems(orderEntry.getNumberOfItems());
            OrderEntry updatedOrder = orderService.saveOrder(existingOrder);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<OrderEntry> patchOrder(@PathVariable(value = "id") Long id, @RequestBody Map<String, Object> map){
        return orderService.patchOrder(id, map);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderEntry>> getFilteredOrders(
            @RequestParam(required = false) String  details,
            @RequestParam(required = false) Integer numberOfItems){
        List<OrderEntry> orders;
        if (details != null && numberOfItems != null){
            orders = orderService.findOrdersByDetailsAndNumberOfItems(details, numberOfItems);
        } else if (details != null) {
            orders = orderService.getOrdersByDetails(details);
        } else if (numberOfItems != null) {
            orders = orderService.getOrdersByNumberOfItems(numberOfItems);
        } else {
            orders = orderService.getAllOrders();
        }
        return ResponseEntity.ok(orders);
    }

}
