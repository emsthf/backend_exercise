package eccomerce.sample.shop.cart.controller;

import eccomerce.sample.shop.cart.dto.ICart;
import eccomerce.sample.shop.cart.model.Cart;
import eccomerce.sample.shop.cart.service.CartService;
import eccomerce.sample.shop.product.service.ProductService;
import eccomerce.sample.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Cart add(@RequestBody ICart iCart) {
        return cartService.addOrder(
                new Cart(
                        userService.getUser(iCart.getUserId()).get(),
                        productService.getProduct(iCart.getProductId()).get()
                )
        );
    }

    @GetMapping("/getAll")
    public List<Cart> getAll() {
        return cartService.getAllOrder();
    }

    @GetMapping("/get/{id}")
    public Optional<Cart> get(@PathVariable("id") Long id) {
        return cartService.getOrder(id);
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        cartService.delOrder(id);
    }
}