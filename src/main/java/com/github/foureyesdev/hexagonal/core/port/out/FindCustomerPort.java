package com.github.foureyesdev.hexagonal.core.port.out;

import com.github.foureyesdev.hexagonal.core.model.Customer;

import java.util.Optional;

public interface FindCustomerPort {

    Optional<Customer> findById(String id);
}
