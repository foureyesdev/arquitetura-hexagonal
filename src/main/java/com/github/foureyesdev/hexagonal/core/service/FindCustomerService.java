package com.github.foureyesdev.hexagonal.core.service;

import com.github.foureyesdev.hexagonal.core.exception.RecursoNaoEncontradoException;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.out.FindCustomerPort;

public class FindCustomerService {

    private final FindCustomerPort findCustomer;

    public FindCustomerService(FindCustomerPort findCustomer) {
        this.findCustomer = findCustomer;
    }

    public Customer find(String id) {
        return findCustomer.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoException("Customer not found")
        );
    }
}
