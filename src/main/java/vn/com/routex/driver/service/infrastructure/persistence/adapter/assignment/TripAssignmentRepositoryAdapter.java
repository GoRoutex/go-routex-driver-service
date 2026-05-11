package vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.assignment.model.TripAssignmentRecord;
import vn.com.routex.driver.service.domain.assignment.port.TripAssignmentRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment.mapper.RouteAssignmentPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.repository.TripAssignmentEntityRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TripAssignmentRepositoryAdapter implements TripAssignmentRepositoryPort {
    private final TripAssignmentEntityRepository tripAssignmentEntityRepository;
    private final RouteAssignmentPersistenceMapper routeAssignmentPersistenceMapper;

    @Override
    public Optional<TripAssignmentRecord> findById(String id) {
        return tripAssignmentEntityRepository.findById(id).map(routeAssignmentPersistenceMapper::toDomain);
    }

    @Override
    public TripAssignmentRecord save(TripAssignmentRecord assignment) {
        return routeAssignmentPersistenceMapper.toDomain(tripAssignmentEntityRepository.save(routeAssignmentPersistenceMapper.toEntity(assignment)));
    }
}
