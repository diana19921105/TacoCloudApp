package hu.dia.tacocloud.repository;

import hu.dia.tacocloud.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
