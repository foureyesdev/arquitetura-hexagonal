package com.github.foureyesdev.hexagonal.adapter.out.client.mapper;

import com.github.foureyesdev.hexagonal.adapter.out.client.dto.AddressResponse;
import com.github.foureyesdev.hexagonal.core.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressResponse response);
}
