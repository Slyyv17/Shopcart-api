package com.Yeagarist.product.services;

import com.Yeagarist.product.Command;
import com.Yeagarist.product.ProductRepository;
import com.Yeagarist.product.model.Product;
import com.Yeagarist.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService implements Command<Void, List<ProductDTO>> {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // new get mapping to find by id

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        // which we can reference below:
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

        // don't throw an exception --> if none found
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS); // return
    }
}
