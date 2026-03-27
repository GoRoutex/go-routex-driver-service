package vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.entity.RouteAssignmentJpaEntity;

import java.util.Optional;

@Repository
public interface RouteAssignmentJpaRepository extends JpaRepository<RouteAssignmentJpaEntity, String> {

    Optional<RouteAssignmentJpaEntity> findByRouteId(String routeId);
}
