package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByCode(String code);
}
