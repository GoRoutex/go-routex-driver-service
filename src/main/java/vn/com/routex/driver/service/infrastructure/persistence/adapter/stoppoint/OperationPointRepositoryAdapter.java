package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.operationpoint.model.OperationPoint;
import vn.com.routex.driver.service.domain.operationpoint.port.OperationPointRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper.StopPointPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository.OperationPointEntityRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OperationPointRepositoryAdapter implements OperationPointRepositoryPort {
    private final OperationPointEntityRepository operationPointEntityRepository;

    @Override
    public Optional<OperationPoint> findById(String id) {
        return operationPointEntityRepository.findById(id).map(StopPointPersistenceMapper::toDomain);
    }

    @Override
    public OperationPoint save(OperationPoint operationPoint) {
        return StopPointPersistenceMapper.toDomain(operationPointEntityRepository.save(StopPointPersistenceMapper.toEntity(operationPoint)));
    }
}
