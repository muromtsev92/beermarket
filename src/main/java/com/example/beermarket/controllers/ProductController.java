package com.example.beermarket.controllers;

import com.example.beermarket.models.Product;
import com.example.beermarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name="title", required = false) String title, Model model){
        model.addAttribute("products", productService.getProductsList(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "products-info";
    }

    @PostMapping("product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("product/delete/{id}")
    public String deleteProduct( @PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
