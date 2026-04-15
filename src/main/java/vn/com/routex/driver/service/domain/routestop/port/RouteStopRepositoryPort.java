package vn.com.routex.driver.service.domain.routestop.port;

import vn.com.routex.driver.service.domain.routestop.model.RouteStopPlan;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface RouteStopRepositoryPort {
    Optional<RouteStopPlan> findById(String id);

    RouteStopPlan save(RouteStopPlan routeStopPlan);
}
