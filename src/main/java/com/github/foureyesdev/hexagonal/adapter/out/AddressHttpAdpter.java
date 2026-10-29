package com.github.foureyesdev.hexagonal.adapter.out;

import com.github.foureyesdev.hexagonal.adapter.out.client.AddressClient;
import com.github.foureyesdev.hexagonal.adapter.out.client.mapper.AddressMapper;
import com.github.foureyesdev.hexagonal.adapter.out.client.response.AddressResponse;
import com.github.foureyesdev.hexagonal.application.core.domain.Address;
import com.github.foureyesdev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class AddressHttpAdpter implements FindAddressByZipCodeOutputPort {

    private final AddressClient client;
    private final AddressMapper mapper;

    public AddressHttpAdpter(AddressClient client, AddressMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse response = client.findByZipCode(zipCode);
        return mapper.toAddress(response);
    }
}
