package com.proyecto.proyecto.service;



import com.proyecto.proyecto.model.exceptions.ApiRestException;
import com.proyecto.proyecto.model.request.ProductRequest;
import com.proyecto.proyecto.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest product) throws ApiRestException;

    ProductResponse update(String id, ProductRequest product);

    List<ProductResponse> searchAll();
}
