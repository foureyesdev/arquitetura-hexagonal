package com.github.foureyesdev.hexagonal.adpters.out.client.mapper;

import com.github.foureyesdev.hexagonal.adpters.out.client.response.AddressResponse;
import com.github.foureyesdev.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressResponse response);
}
