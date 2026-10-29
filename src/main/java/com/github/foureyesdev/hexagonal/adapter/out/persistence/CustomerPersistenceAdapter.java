package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.application.core.domain.Customer;
import com.github.foureyesdev.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CustomerPersistenceAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerPersistenceAdapter(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }
}
