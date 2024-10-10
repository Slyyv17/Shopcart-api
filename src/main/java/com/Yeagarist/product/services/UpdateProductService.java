package com.Yeagarist.product.services;

import com.Yeagarist.exceptions.ProductNotFoundException;
import com.Yeagarist.product.Command;
import com.Yeagarist.product.ProductRepository;
import com.Yeagarist.product.model.Product;
import com.Yeagarist.product.model.ProductDTO;
import com.Yeagarist.product.model.UpdateProductCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> optionalProduct = productRepository.findById(command.getId());

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        // Throw an exception
        throw new ProductNotFoundException();
    }
}
