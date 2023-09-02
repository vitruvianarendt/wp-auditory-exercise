package mk.ukim.finki.wpaud.repository.jpa;

import mk.ukim.finki.wpaud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String name, String password);
    Optional<User> findByUsername(String name);

}
