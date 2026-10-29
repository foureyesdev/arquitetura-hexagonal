package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.core.model.Customer;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity entity);
}
