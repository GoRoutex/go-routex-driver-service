package vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.entity.RouteAssignmentEntityAbstract;

import java.util.Optional;

@Repository
public interface RouteAssignmentJpaRepository extends JpaRepository<RouteAssignmentEntityAbstract, String> {

    Optional<RouteAssignmentEntityAbstract> findByRouteId(String routeId);
}
