package vn.com.routex.driver.service.domain.route.port;

import vn.com.routex.driver.service.domain.route.model.Route;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface RouteRepositoryPort {
    Optional<Route> findById(String id);

    Route save(Route route);
}
