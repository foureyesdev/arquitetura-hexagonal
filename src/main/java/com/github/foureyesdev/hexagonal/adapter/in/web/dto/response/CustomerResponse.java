package com.github.foureyesdev.hexagonal.adapter.in.web.dto.response;

public record CustomerResponse (
        String id,
        String name,
        AddressResponse address,
        String cpf,
        Boolean isValidCpf
) {
}
