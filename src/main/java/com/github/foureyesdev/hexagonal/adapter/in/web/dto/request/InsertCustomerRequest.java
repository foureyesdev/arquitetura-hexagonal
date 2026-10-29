package com.github.foureyesdev.hexagonal.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record InsertCustomerRequest(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank String zipCode
) {
}
