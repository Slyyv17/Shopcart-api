package com.Yeagarist.product.services;

import com.Yeagarist.exceptions.ProductNotFoundException;
import com.Yeagarist.product.Command;
import com.Yeagarist.product.ProductRepository;
import com.Yeagarist.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        // later we will throw product not found exception

        throw new ProductNotFoundException();
    }
}
