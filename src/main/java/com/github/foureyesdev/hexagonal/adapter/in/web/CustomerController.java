package com.github.foureyesdev.hexagonal.adapter.in.web;

import com.github.foureyesdev.hexagonal.adapter.in.web.dto.InsertCustomerRequest;
import com.github.foureyesdev.hexagonal.adapter.in.web.mapper.CustomerMapper;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.in.InsertCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase customerUseCase;
    private final CustomerMapper mapper;

    public CustomerController(InsertCustomerUseCase customerUseCase, CustomerMapper mapper) {
        this.customerUseCase = customerUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody final InsertCustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        customerUseCase.insert(customer, request.zipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
