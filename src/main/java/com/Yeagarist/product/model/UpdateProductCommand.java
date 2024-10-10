package com.Yeagarist.product.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UpdateProductCommand {
    private Integer id;
    private Product product;

    public UpdateProductCommand(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }
    
}
