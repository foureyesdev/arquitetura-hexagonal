package com.github.foureyesdev.hexagonal.core.port.out;

import com.github.foureyesdev.hexagonal.core.model.Address;

public interface AddressPort {

    Address find(String zipCode);
}
