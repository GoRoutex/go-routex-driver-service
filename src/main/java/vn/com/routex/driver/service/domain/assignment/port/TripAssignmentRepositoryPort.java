package vn.com.routex.driver.service.domain.assignment.port;


import vn.com.routex.driver.service.domain.assignment.model.TripAssignmentRecord;

import java.util.Optional;

/**
 * Domain repository port (no Spring Data/JPA dependency).
 */
public interface TripAssignmentRepositoryPort {
    Optional<TripAssignmentRecord> findById(String id);
    Optional<TripAssignmentRecord> findByTripId(String tripId);
    TripAssignmentRecord save(TripAssignmentRecord assignment);
}
