package vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.StopPointJpaEntity;

@Repository
public interface StopPointJpaRepository extends JpaRepository<StopPointJpaEntity, String> {
}
