package com.github.foureyesdev.hexagonal.core.port.in;

import com.github.foureyesdev.hexagonal.core.model.Customer;

public interface FindCustomerUseCase {

    Customer find(String id);
}
