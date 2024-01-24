package com.example.beermarket.services;

import com.example.beermarket.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextID = 0L;

    {
        products.add(new Product(++nextID, "Klinskoye", "desc", 50, "Tyumen", "IvanKB"));
        products.add(new Product(++nextID, "Baltika", "desc", 70, "Tyumen", "Fedor"));
    }

    public List<Product> getProductsList() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++nextID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for(Product p: products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
