package com.github.foureyesdev.hexagonal.core.service;

import com.github.foureyesdev.hexagonal.core.model.Address;
import com.github.foureyesdev.hexagonal.core.model.Customer;
import com.github.foureyesdev.hexagonal.core.port.in.UpdateCustomerUseCase;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;

public class UpdateCustomerService implements UpdateCustomerUseCase {

    private final FindCustomerService findCustomerService;
    private final AddressPort addressPort;
    private final CustomerRepositoryPort customerRepositoryPort;

    public UpdateCustomerService(
            FindCustomerService findCustomerService,
            AddressPort addressPort,
            CustomerRepositoryPort customerRepositoryPort) {
        this.findCustomerService = findCustomerService;
        this.addressPort = addressPort;
        this.customerRepositoryPort = customerRepositoryPort;
    }

    public void update(Customer customer, String zipCode) {
        Customer foundCustomer = findCustomerService.find(customer.getId());
        Address address = addressPort.find(zipCode);

        foundCustomer.getAddress().setStreet(address.getStreet());
        foundCustomer.getAddress().setCity(address.getCity());
        foundCustomer.getAddress().setState(address.getState());

        customerRepositoryPort.save(foundCustomer);
    }
}
