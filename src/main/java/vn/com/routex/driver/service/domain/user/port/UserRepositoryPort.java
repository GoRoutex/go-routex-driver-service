package vn.com.routex.driver.service.domain.user.port;

import vn.com.routex.driver.service.domain.user.model.User;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 * Infrastructure layer provides an adapter implementation.
 */
public interface UserRepositoryPort {
    Optional<User> findById(String id);

    User save(User user);
}
