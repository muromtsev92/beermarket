package com.example.beermarket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String Title;
    private String description;
    private Integer price;
    private String city;
    private String author;
}
