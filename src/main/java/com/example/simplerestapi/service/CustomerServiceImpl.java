package com.example.simplerestapi.service;

import com.example.simplerestapi.entity.Customer;
import com.example.simplerestapi.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceIml getById ()", id);
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer save(Customer customer) {
        log.info("IN CustomerServiceIml save ()", customer);
        Customer save = customerRepo.save(customer);
        return save;
    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceIml delete ()", id);
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceIml getAll ()");
        return customerRepo.findAll();
    }
}
