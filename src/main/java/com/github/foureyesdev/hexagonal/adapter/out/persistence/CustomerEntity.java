package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private String name;

    private AddressEntity address;

    private String cpf;

    private Boolean isValidCpf;
}
