package eccomerce.sample.shop.cart.service;

import eccomerce.sample.shop.cart.model.Cart;
import eccomerce.sample.shop.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addOrder(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllOrder() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getOrder(Long id) {
        return Optional.ofNullable(cartRepository.findById(id).get());
    }

    @Override
    public void delOrder(Long id) {
        cartRepository.deleteById(id);
    }
}
