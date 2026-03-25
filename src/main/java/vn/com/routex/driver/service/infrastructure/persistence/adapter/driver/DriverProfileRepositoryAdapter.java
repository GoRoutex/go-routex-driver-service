package vn.com.routex.driver.service.infrastructure.persistence.adapter.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.domain.driver.port.DriverProfileRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.driver.mapper.DriverProfilePersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.repository.DriverProfileJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DriverProfileRepositoryAdapter implements DriverProfileRepositoryPort {
    private final DriverProfileJpaRepository driverProfileJpaRepository;

    @Override
    public Optional<DriverProfile> findById(String id) {
        return driverProfileJpaRepository.findById(id).map(DriverProfilePersistenceMapper::toDomain);
    }

    @Override
    public Optional<DriverProfile> findByUserId(String userId) {
        return driverProfileJpaRepository.findByUserId(userId).map(DriverProfilePersistenceMapper::toDomain);
    }

    @Override
    public DriverProfile save(DriverProfile profile) {
        return DriverProfilePersistenceMapper.toDomain(driverProfileJpaRepository.save(DriverProfilePersistenceMapper.toEntity(profile)));
    }
}
