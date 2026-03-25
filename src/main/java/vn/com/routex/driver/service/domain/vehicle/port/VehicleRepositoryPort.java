package vn.com.routex.driver.service.domain.vehicle.port;

import vn.com.routex.driver.service.domain.vehicle.model.Vehicle;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface VehicleRepositoryPort {
    Optional<Vehicle> findById(String id);

    Vehicle save(Vehicle vehicle);
}
