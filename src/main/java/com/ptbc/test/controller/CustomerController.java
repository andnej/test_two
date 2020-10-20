package com.ptbc.test.controller;

import com.ptbc.test.entity.Customer;
import com.ptbc.test.exception.CustomerNotFoundException;
import com.ptbc.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> all() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setPhone(newCustomer.getPhone());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}
