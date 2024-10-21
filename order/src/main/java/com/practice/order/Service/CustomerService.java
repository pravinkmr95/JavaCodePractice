package com.practice.order.Service;

import com.practice.order.Entity.Customer;
import com.practice.order.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Page<Customer> getCustomersPaginated(int start, int size, String sortBy){
        Pageable pageable = PageRequest.of(start, size, Sort.by(sortBy));
        return customerRepository.findAll(pageable);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByName(String name){
        return customerRepository.getCustomerByName(name);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
