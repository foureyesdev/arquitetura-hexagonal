package com.github.foureyesdev.hexagonal.config;

import com.github.foureyesdev.hexagonal.core.service.InsertCustomerService;
import com.github.foureyesdev.hexagonal.core.port.out.AddressPort;
import com.github.foureyesdev.hexagonal.core.port.out.InsertCustomerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreServicesConfig {

    @Bean
    public InsertCustomerService insertCustomerService(
            AddressPort findAddressOutputPort,
            InsertCustomerPort customerOutputPort
    ) {
        return new InsertCustomerService(
                findAddressOutputPort,
                customerOutputPort
        );
    }
}
