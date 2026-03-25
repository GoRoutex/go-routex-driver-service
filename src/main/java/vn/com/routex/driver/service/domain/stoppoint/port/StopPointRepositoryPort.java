package vn.com.routex.driver.service.domain.stoppoint.port;

import vn.com.routex.driver.service.domain.stoppoint.model.StopPoint;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface StopPointRepositoryPort {
    Optional<StopPoint> findById(String id);

    StopPoint save(StopPoint stopPoint);
}
