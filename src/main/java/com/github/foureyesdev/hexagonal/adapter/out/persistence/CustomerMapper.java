package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import com.github.foureyesdev.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
