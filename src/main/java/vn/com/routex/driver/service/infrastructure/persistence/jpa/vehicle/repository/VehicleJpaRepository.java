package vn.com.routex.driver.service.infrastructure.persistence.jpa.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.vehicle.entity.VehicleJpaEntity;

@Repository
public interface VehicleJpaRepository extends JpaRepository<VehicleJpaEntity, String> {
}
