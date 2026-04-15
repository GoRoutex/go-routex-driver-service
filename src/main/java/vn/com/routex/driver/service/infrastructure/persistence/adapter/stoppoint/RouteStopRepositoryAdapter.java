package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.routestop.model.RouteStopPlan;
import vn.com.routex.driver.service.domain.routestop.port.RouteStopRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper.RouteStopPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.repository.RouteStopEntityRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RouteStopRepositoryAdapter implements RouteStopRepositoryPort {
    private final RouteStopEntityRepository routeStopEntityRepository;

    @Override
    public Optional<RouteStopPlan> findById(String id) {
        return routeStopEntityRepository.findById(id).map(RouteStopPersistenceMapper::toDomain);
    }

    @Override
    public RouteStopPlan save(RouteStopPlan routeStopPlan) {
        return RouteStopPersistenceMapper.toDomain(routeStopEntityRepository.save(RouteStopPersistenceMapper.toEntity(routeStopPlan)));
    }
}
