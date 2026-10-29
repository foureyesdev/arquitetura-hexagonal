package com.github.foureyesdev.hexagonal.adapter.out.http.dto;

public record AddressResponse (
        String street,
        String city,
        String state
) {
}
