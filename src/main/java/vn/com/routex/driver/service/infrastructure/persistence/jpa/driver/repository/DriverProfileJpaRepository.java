package vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.entity.DriverProfileJpaEntity;

import java.util.Optional;

@Repository
public interface DriverProfileJpaRepository extends JpaRepository<DriverProfileJpaEntity, String> {
    Optional<DriverProfileJpaEntity> findByUserId(String userId);
}
