package vn.com.routex.driver.service.infrastructure.persistence.adapter.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.route.model.Route;
import vn.com.routex.driver.service.domain.route.port.RouteRepositoryPort;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.route.mapper.RoutePersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.route.repository.RouteJpaRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RouteRepositoryAdapter implements RouteRepositoryPort {
    private final RouteJpaRepository routeJpaRepository;

    @Override
    public Optional<Route> findById(String id) {
        return routeJpaRepository.findById(id).map(RoutePersistenceMapper::toDomain);
    }

    @Override
    public Route save(Route route) {
        return RoutePersistenceMapper.toDomain(routeJpaRepository.save(RoutePersistenceMapper.toEntity(route)));
    }
}
