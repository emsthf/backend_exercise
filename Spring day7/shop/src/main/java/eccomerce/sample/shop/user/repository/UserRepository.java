package eccomerce.sample.shop.user.repository;

import eccomerce.sample.shop.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
