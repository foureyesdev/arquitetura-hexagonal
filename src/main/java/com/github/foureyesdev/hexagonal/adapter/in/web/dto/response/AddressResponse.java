package com.github.foureyesdev.hexagonal.adapter.in.web.dto.response;

public record AddressResponse (
        String street,
        String city,
        String state
) {
}
