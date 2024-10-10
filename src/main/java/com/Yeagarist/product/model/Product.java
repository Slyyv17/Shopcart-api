package com.Yeagarist.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Maps java class to MySQL
@Data // comes from the java lombok
@Table(name = "product")

public class Product {

    @Id // all table in mysql need a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*
    auto generates id and start counting from 1. 1,2,3 etc.
    */
    @Column(name = "id") // It tells mysql that the column name will be id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;
}
