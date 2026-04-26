package vn.com.routex.driver.service.infrastructure.persistence.adapter.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.vehicle.model.VehicleProfile;
import vn.com.routex.driver.service.domain.vehicle.port.VehicleRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.vehicle.mapper.VehiclePersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.vehicle.repository.VehicleEntityRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleRepositoryAdapter implements VehicleRepositoryPort {
    private final VehicleEntityRepository vehicleEntityRepository;
    private final VehiclePersistenceMapper vehiclePersistenceMapper;

    @Override
    public Optional<VehicleProfile> findById(String id) {
        return vehicleEntityRepository.findById(id).map(vehiclePersistenceMapper::toDomain);
    }

    @Override
    public Optional<VehicleProfile> findById(String vehicleId, String merchantId) {
        return Optional.empty();
    }

    @Override
    public void save(VehicleProfile vehicle) {
        vehiclePersistenceMapper.toDomain(vehicleEntityRepository.save(vehiclePersistenceMapper.toEntity(vehicle)));
    }
}
