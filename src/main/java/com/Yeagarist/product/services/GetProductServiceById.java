package com.Yeagarist.product.services;

import com.Yeagarist.exceptions.ProductNotFoundException;
import com.Yeagarist.product.ProductRepository;
import com.Yeagarist.product.Query;
import com.Yeagarist.product.model.Product;
import com.Yeagarist.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductServiceById implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductServiceById(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        // account for null value if db can't find it
        Optional<Product> productOptional = productRepository.findById(input);

        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        // Throw an exception

        throw new ProductNotFoundException();
    }
}
