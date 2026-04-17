package vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.entity.DriverProfileEntityAbstract;

import java.util.Optional;

@Repository
public interface DriverProfileJpaRepository extends JpaRepository<DriverProfileEntityAbstract, String> {
    Optional<DriverProfileEntityAbstract> findByUserId(String userId);
}
