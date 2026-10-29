package com.github.foureyesdev.hexagonal.adapter.in.web.mapper;

import com.github.foureyesdev.hexagonal.adapter.in.web.dto.request.InsertCustomerRequest;
import com.github.foureyesdev.hexagonal.adapter.in.web.dto.response.CustomerResponse;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCustomer(InsertCustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
