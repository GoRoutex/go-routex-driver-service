package vn.com.routex.driver.service.infrastructure.persistence.adapter.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.vehicle.model.Vehicle;
import vn.com.routex.driver.service.domain.vehicle.port.VehicleRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.vehicle.mapper.VehiclePersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.vehicle.repository.VehicleJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleRepositoryAdapter implements VehicleRepositoryPort {
    private final VehicleJpaRepository vehicleJpaRepository;

    @Override
    public Optional<Vehicle> findById(String id) {
        return vehicleJpaRepository.findById(id).map(VehiclePersistenceMapper::toDomain);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return VehiclePersistenceMapper.toDomain(vehicleJpaRepository.save(VehiclePersistenceMapper.toEntity(vehicle)));
    }
}
