package com.github.foureyesdev.hexagonal.application.ports.out;

import com.github.foureyesdev.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
