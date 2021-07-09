package com.example.simplerestapi.controller;

import com.example.simplerestapi.entity.Customer;
import com.example.simplerestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public record CustomerController(CustomerService customerService) {
    @Autowired
    public CustomerController {
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = customerService.getById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer save = customerService.save(customer);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> all = customerService.getAll();

        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
}
