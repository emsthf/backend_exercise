package eccomerce.sample.shop.product.controller;

import eccomerce.sample.shop.product.model.Product;
import eccomerce.sample.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/builder")
    public Product testBuilder(@RequestBody Product product) {
        return Product.builder()   // 빌더의 여러 기능이 있지만 빌터 생성자에 순서 상관 없이 넣을 수 있는 장점이 있다
                .sale(10)
                .price(300)
                .productName("BuilderTest")
                .description("asdf")
                .build();   // 필드를 다 넣었으면 .build()로 마무리
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAllProduct();
    }

    @GetMapping("/get/{id}")
    public Optional<Product> get(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        productService.delProduct(id);
    }
}
