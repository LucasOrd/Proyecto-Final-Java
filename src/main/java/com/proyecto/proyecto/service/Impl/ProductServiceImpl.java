package com.proyecto.proyecto.service.Impl;

import com.proyecto.proyecto.model.document.Product;
import com.proyecto.proyecto.service.ProductService;
import com.proyecto.proyecto.builder.ProductBuilder;
import com.proyecto.proyecto.model.exceptions.ApiRestException;
import com.proyecto.proyecto.model.request.ProductRequest;
import com.proyecto.proyecto.model.response.ProductResponse;
import com.proyecto.proyecto.repository.CategoryRepository;
import com.proyecto.proyecto.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse create(ProductRequest request) throws ApiRestException {
        validateRequestCreate(request);
        var document = productRepository.save(ProductBuilder.requestToDocumentCreate(request));
        return ProductBuilder.documentToResponseCreate(document);
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        var product =
                ProductBuilder.requestToDocumentUpdate(request);
        product.setId(id);
        var productSaved = productRepository.save(product);
        return ProductBuilder.documentToResponseCreate(productSaved);
    }

    @Override
    public List<ProductResponse> searchAll() {
        return ProductBuilder.Response(productRepository.findAll());
    }

    private void validateRequestCreate(ProductRequest request) throws ApiRestException {
        var category = categoryRepository.findByCode(request.getCategory().getCode());
        var product = productRepository.findByCode(request.getCode());

        if (Objects.isNull(category)) {
            throw new ApiRestException("La categoria no existe");
        }
        if (!Objects.isNull(product)) {
            throw new ApiRestException("El producto ya existe");
        }
    }

}
