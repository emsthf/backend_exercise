package com.union.JPA.exercise.controller;

import com.union.JPA.exercise.model.Product;
import com.union.JPA.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products/new")
    public String createProductForm() {
        return "products/createProductForm";
    }

    @PostMapping(value = "/products/new")
    public String addProduct(ProductForm productForm) {
        Product product = new Product();

        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());

        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping(value = "/products")
    public String productList(Model model) {
        List<Product> product = productService.getAllProduct();
        model.addAttribute("product", product);
        return "products/productList";
    }

//    @GetMapping("/getProduct/{id}")
//    public String getProduct(@PathVariable("id") int id) {
//        Optional<Product> product = productService.getProduct(id);
//        return "products/getProduct";
//    }
//
//    @DeleteMapping("/delProduct/{id}")
//    public String delProduct(@PathVariable("id") int id) {
//        productService.delProduct(id);
//        return "redirect:/";
//    }
}
