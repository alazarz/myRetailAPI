package com.example.myRetail.Data.Repositories;

import com.example.myRetail.Data.Models.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface PriceRepository extends MongoRepository<Price, Long> {
    Optional<Price> findById(Long productId);
}
