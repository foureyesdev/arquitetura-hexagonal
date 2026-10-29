package com.github.foureyesdev.hexagonal.core.port.out;

import com.github.foureyesdev.hexagonal.core.model.Customer;

public interface InsertCustomerPort {

    void insert(Customer customer);
}
