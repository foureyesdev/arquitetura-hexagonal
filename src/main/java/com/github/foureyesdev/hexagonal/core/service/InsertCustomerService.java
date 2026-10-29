package com.github.foureyesdev.hexagonal.core.service;

import com.github.foureyesdev.hexagonal.core.model.Address;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.in.InsertCustomerUseCase;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import com.github.foureyesdev.hexagonal.core.port.out.InsertCustomerPort;

public class InsertCustomerService implements InsertCustomerUseCase {

    private final AddressPort findAddress;
    private final InsertCustomerPort insertCustomer;

    public InsertCustomerService(AddressPort findAddress, InsertCustomerPort insertCustomer) {
        this.findAddress = findAddress;
        this.insertCustomer = insertCustomer;
    }

    public void insert(Customer customer, String zipCode) {
        Address address = findAddress.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
