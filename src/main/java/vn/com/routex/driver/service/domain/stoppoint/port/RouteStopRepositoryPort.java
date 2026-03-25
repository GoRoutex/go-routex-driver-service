package vn.com.routex.driver.service.domain.stoppoint.port;

import vn.com.routex.driver.service.domain.stoppoint.model.RouteStop;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface RouteStopRepositoryPort {
    Optional<RouteStop> findById(String id);

    RouteStop save(RouteStop routeStop);
}
