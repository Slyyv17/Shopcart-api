package com.Yeagarist.product;

import com.Yeagarist.exceptions.ProductNotFoundException;
import com.Yeagarist.product.model.ErrorResponse;
import com.Yeagarist.product.model.Product;
import com.Yeagarist.product.model.ProductDTO;
import com.Yeagarist.product.model.UpdateProductCommand;
import com.Yeagarist.product.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {

    // Dependency Injection
    // Field Injection
    // Not the best way to do it, but for now it's fine;
    /* Don't use @Autowired use final, and
        return the variables of each classes then create a constructor
        of the instance variable
     */

    private final CreateProductService createProductService;
    private final GetProductService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final GetProductServiceById getProductServiceById;

    public ProductController
            (CreateProductService createProductService,
             GetProductService getProductService,
             UpdateProductService updateProductService,
             DeleteProductService deleteProductService,
             GetProductServiceById getProductServiceById) {

        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductServiceById = getProductServiceById;
    }

    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductService.execute(null);
    }

    // new get mapping for find by id
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductsById(@PathVariable Integer id) {
        return getProductServiceById.execute(id);
    }


    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> updateProducts(@PathVariable Integer id,
                                                     @RequestBody Product product) {
        /* we need to pass both id & product together
        but our execute method is designed to pass in only one thing
         */
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }

}
