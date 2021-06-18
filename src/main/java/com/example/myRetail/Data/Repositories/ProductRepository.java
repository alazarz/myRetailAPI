package com.example.myRetail.Data.Repositories;

import com.example.myRetail.Data.Models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<Product> findById(Long id);
    Product updateProduct(Product product);
}
