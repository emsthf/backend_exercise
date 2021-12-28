package eccomerce.sample.shop.cart.service;

import eccomerce.sample.shop.cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart addOrder(Cart cart);
    List<Cart> getAllOrder();
    Optional<Cart> getOrder(Long id);
    void delOrder(Long id);
}