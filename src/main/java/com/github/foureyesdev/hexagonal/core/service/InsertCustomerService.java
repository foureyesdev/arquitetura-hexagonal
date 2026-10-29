package com.github.foureyesdev.hexagonal.core.service;

import com.github.foureyesdev.hexagonal.core.model.Address;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.in.InsertCustomerUseCase;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;

public class InsertCustomerService implements InsertCustomerUseCase {

    private final AddressPort findAddress;
    private final CustomerRepositoryPort customerPort;

    public InsertCustomerService(AddressPort findAddress, CustomerRepositoryPort customerPort) {
        this.findAddress = findAddress;
        this.customerPort = customerPort;
    }

    public void insert(Customer customer, String zipCode) {
        Address address = findAddress.find(zipCode);
        customer.setAddress(address);
        customerPort.insert(customer);
    }
}
