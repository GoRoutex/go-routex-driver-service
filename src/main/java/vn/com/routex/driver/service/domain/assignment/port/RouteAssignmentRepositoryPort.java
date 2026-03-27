package vn.com.routex.driver.service.domain.assignment.port;

import vn.com.routex.driver.service.domain.assignment.model.RouteAssignment;
import vn.com.routex.driver.service.domain.route.model.Route;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface RouteAssignmentRepositoryPort {
    Optional<RouteAssignment> findById(String id);
    Optional<RouteAssignment> findByRouteId(String routeId);
    RouteAssignment save(RouteAssignment assignment);
}
