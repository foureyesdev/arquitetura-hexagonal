package com.github.foureyesdev.hexagonal.adapter.in.web.mapper;

import com.github.foureyesdev.hexagonal.adapter.in.web.dto.InsertCustomerRequest;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(InsertCustomerRequest request);
}
