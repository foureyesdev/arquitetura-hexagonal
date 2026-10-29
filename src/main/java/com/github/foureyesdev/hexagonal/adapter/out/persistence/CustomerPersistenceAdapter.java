package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements CustomerRepositoryPort {

    private final CustomerEntityRepository repository;
    private final CustomerEntityMapper mapper;

    public CustomerPersistenceAdapter(CustomerEntityRepository repository, CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }

    @Override
    public Optional<Customer> findById(String id) {
        Optional<CustomerEntity> customerEntity = repository.findById(id);
        return customerEntity.map(mapper::toCustomer);
    }
}
