package com.example.simplerestapi.repo;

import com.example.simplerestapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
