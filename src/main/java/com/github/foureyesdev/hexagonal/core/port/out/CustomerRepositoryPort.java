package com.github.foureyesdev.hexagonal.core.port.out;

import com.github.foureyesdev.hexagonal.core.model.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {

    void insert(Customer customer);
    Optional<Customer> findById(String id);
}
