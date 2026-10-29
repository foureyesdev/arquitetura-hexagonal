package com.github.foureyesdev.hexagonal.core.port.in;

import com.github.foureyesdev.hexagonal.core.model.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipCode);
}
