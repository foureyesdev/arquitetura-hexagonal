package com.github.foureyesdev.hexagonal.adapter.out.http;

import com.github.foureyesdev.hexagonal.adapter.out.http.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "AddressClient",
        url = "${spring.client.address.url}"
)
public interface AddressClient {

    @GetMapping("/{zipCode}")
    AddressResponse findByZipCode(@PathVariable("zipCode") String zipCode);
}
