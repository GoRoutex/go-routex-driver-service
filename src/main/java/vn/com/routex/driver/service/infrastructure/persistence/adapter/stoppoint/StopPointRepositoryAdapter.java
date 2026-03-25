package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.stoppoint.model.StopPoint;
import vn.com.routex.driver.service.domain.stoppoint.port.StopPointRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper.StopPointPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository.StopPointJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StopPointRepositoryAdapter implements StopPointRepositoryPort {
    private final StopPointJpaRepository stopPointJpaRepository;

    @Override
    public Optional<StopPoint> findById(String id) {
        return stopPointJpaRepository.findById(id).map(StopPointPersistenceMapper::toDomain);
    }

    @Override
    public StopPoint save(StopPoint stopPoint) {
        return StopPointPersistenceMapper.toDomain(stopPointJpaRepository.save(StopPointPersistenceMapper.toEntity(stopPoint)));
    }
}
