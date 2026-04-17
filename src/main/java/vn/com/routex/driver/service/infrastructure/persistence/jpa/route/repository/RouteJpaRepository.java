package vn.com.routex.driver.service.infrastructure.persistence.jpa.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.route.entity.RouteEntityAbstract;

@Repository
public interface RouteJpaRepository extends JpaRepository<RouteEntityAbstract, String> {
}
