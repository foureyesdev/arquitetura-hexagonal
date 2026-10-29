package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CustomerPersistenceAdapter implements CustomerRepositoryPort {

    private final CustomerRepository repository;
    private final CustomerEntityMapper mapper;

    public CustomerPersistenceAdapter(CustomerRepository repository, CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }
}
