package com.safiribytes.shoppingmicroservice.product.repository;

import com.safiribytes.shoppingmicroservice.product.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
