package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.out.FindCustomerPort;
import com.github.foureyesdev.hexagonal.core.port.out.InsertCustomerPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements
        InsertCustomerPort,
        FindCustomerPort
{

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

    @Override
    public Optional<Customer> findById(String id) {
        Optional<CustomerEntity> customerEntity = repository.findById(id);
        Optional<Customer> customer = customerEntity.map(mapper::toCustomer);
        return customer;
    }
}
