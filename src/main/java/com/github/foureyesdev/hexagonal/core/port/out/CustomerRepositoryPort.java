package com.github.foureyesdev.hexagonal.core.port.out;

import com.github.foureyesdev.hexagonal.core.model.Customer;

public interface CustomerRepositoryPort {

    void insert(Customer customer);
}
