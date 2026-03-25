package vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.assignment.model.RouteAssignment;
import vn.com.routex.driver.service.domain.assignment.port.RouteAssignmentRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment.mapper.RouteAssignmentPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.repository.RouteAssignmentJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RouteAssignmentRepositoryAdapter implements RouteAssignmentRepositoryPort {
    private final RouteAssignmentJpaRepository routeAssignmentJpaRepository;

    @Override
    public Optional<RouteAssignment> findById(String id) {
        return routeAssignmentJpaRepository.findById(id).map(RouteAssignmentPersistenceMapper::toDomain);
    }

    @Override
    public RouteAssignment save(RouteAssignment assignment) {
        return RouteAssignmentPersistenceMapper.toDomain(routeAssignmentJpaRepository.save(RouteAssignmentPersistenceMapper.toEntity(assignment)));
    }
}
