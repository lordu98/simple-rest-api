package com.example.simplerestapi.service;



import com.example.simplerestapi.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    Customer save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();

}
