package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByCode(String code);

}
