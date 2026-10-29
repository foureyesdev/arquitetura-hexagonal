package com.github.foureyesdev.hexagonal.config;

import com.github.foureyesdev.hexagonal.core.port.out.CustomerRepositoryPort;
import com.github.foureyesdev.hexagonal.core.service.FindCustomerService;
import com.github.foureyesdev.hexagonal.core.service.InsertCustomerService;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreServicesConfig {

    @Bean
    public InsertCustomerService insertCustomerService(AddressPort findAddressOutputPort, CustomerRepositoryPort customerPort) {
        return new InsertCustomerService(
                findAddressOutputPort,
                customerPort
        );
    }

    @Bean
    public FindCustomerService findCustomerService(CustomerRepositoryPort customerPort) {
        return new FindCustomerService(customerPort);
    }
}
