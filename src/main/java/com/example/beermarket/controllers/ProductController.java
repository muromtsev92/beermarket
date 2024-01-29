package com.example.beermarket.controllers;

import com.example.beermarket.models.Product;
import com.example.beermarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        Product product = productService.getProductById(id);
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("images", product.getImages());
        return "products-info";
    }

    @PostMapping("product/create")
    public String createProduct(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3") MultipartFile file3,
            Product product
    ) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("product/delete/{id}")
    public String deleteProduct( @PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
