package com.github.foureyesdev.hexagonal.application.ports.out;

import com.github.foureyesdev.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
