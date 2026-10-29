package com.github.foureyesdev.hexagonal.core.service;

import com.github.foureyesdev.hexagonal.core.exception.RecursoNaoEncontradoException;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;

public class FindCustomerService {

    private final CustomerRepositoryPort customerPort;

    public FindCustomerService(CustomerRepositoryPort customerPort) {
        this.customerPort = customerPort;
    }

    public Customer find(String id) {
        return customerPort.findById(id).orElseThrow(
                () -> new RecursoNaoEncontradoException("Customer not found")
        );
    }
}
