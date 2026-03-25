package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.stoppoint.model.RouteStop;
import vn.com.routex.driver.service.domain.stoppoint.port.RouteStopRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper.RouteStopPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository.RouteStopJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RouteStopRepositoryAdapter implements RouteStopRepositoryPort {
    private final RouteStopJpaRepository routeStopJpaRepository;

    @Override
    public Optional<RouteStop> findById(String id) {
        return routeStopJpaRepository.findById(id).map(RouteStopPersistenceMapper::toDomain);
    }

    @Override
    public RouteStop save(RouteStop routeStop) {
        return RouteStopPersistenceMapper.toDomain(routeStopJpaRepository.save(RouteStopPersistenceMapper.toEntity(routeStop)));
    }
}
