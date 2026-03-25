package vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.RouteStopJpaEntity;

@Repository
public interface RouteStopJpaRepository extends JpaRepository<RouteStopJpaEntity, String> {
}
