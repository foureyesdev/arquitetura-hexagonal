package com.github.foureyesdev.hexagonal.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerEntityRepository extends MongoRepository<CustomerEntity, String> {
}
