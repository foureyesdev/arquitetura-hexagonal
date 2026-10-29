package com.github.foureyesdev.hexagonal.adapter.in.web;

import com.github.foureyesdev.hexagonal.adapter.in.web.dto.request.InsertCustomerRequest;
import com.github.foureyesdev.hexagonal.adapter.in.web.dto.response.CustomerResponse;
import com.github.foureyesdev.hexagonal.adapter.in.web.mapper.CustomerMapper;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.in.FindCustomerUseCase;
import com.github.foureyesdev.hexagonal.core.port.in.InsertCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerMapper mapper;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final FindCustomerUseCase findCustomerUseCase;

    public CustomerController(
            CustomerMapper mapper,
            InsertCustomerUseCase customerUseCase,
            FindCustomerUseCase findCustomerUseCase) {
        this.mapper = mapper;
        this.insertCustomerUseCase = customerUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody final InsertCustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        insertCustomerUseCase.insert(customer, request.zipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable final String id) {
        Customer customer = findCustomerUseCase.find(id);
        CustomerResponse response = mapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(response);
    }
}
