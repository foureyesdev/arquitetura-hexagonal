package com.github.foureyesdev.hexagonal.application.core.usecase;

import com.github.foureyesdev.hexagonal.application.core.domain.Address;
import com.github.foureyesdev.hexagonal.application.core.domain.Customer;
import com.github.foureyesdev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.github.foureyesdev.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddress;
    private final InsertCustomerOutputPort insertCustomer;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddress, InsertCustomerOutputPort insertCustomer) {
        this.findAddress = findAddress;
        this.insertCustomer = insertCustomer;
    }

    public void insert(Customer customer, String zipCode) {
        Address address = findAddress.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
