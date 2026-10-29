package com.github.foureyesdev.hexagonal.adapter.out;

import com.github.foureyesdev.hexagonal.adapter.out.client.AddressClient;
import com.github.foureyesdev.hexagonal.adapter.out.client.mapper.AddressMapper;
import com.github.foureyesdev.hexagonal.adapter.out.client.dto.AddressResponse;
import com.github.foureyesdev.hexagonal.core.model.Address;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import org.springframework.stereotype.Component;

@Component
public class AddressHttpAdpter implements AddressPort {

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
