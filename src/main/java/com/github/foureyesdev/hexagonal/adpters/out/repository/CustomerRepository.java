package com.github.foureyesdev.hexagonal.adpters.out.repository;

import com.github.foureyesdev.hexagonal.adpters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
