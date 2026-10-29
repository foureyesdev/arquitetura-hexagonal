package com.github.foureyesdev.hexagonal.adpters.out.client.response;

public record AddressResponse (
        String street,
        String city,
        String state
) {
}
