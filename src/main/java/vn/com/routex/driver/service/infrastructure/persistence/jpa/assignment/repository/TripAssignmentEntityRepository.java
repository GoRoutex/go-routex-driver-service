package vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.entity.TripAssignmentEntity;

import java.util.Optional;

@Repository
public interface TripAssignmentEntityRepository extends JpaRepository<TripAssignmentEntity, String> {

    Optional<TripAssignmentEntity> findByTripId(String tripId);
}
