package com.github.foureyesdev.hexagonal.adapter.out.client.dto;

public record AddressResponse (
        String street,
        String city,
        String state
) {
}
