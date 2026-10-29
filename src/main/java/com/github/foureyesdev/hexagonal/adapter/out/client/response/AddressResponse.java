package com.github.foureyesdev.hexagonal.adapter.out.client.response;

public record AddressResponse (
        String street,
        String city,
        String state
) {
}
