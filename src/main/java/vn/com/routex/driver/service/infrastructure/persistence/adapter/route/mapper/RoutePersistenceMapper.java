package vn.com.routex.driver.service.infrastructure.persistence.adapter.route.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.route.model.Route;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.route.entity.RouteJpaEntity;

@UtilityClass
public class RoutePersistenceMapper {
    public Route toDomain(RouteJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        Route domain = new Route(
                entity.getId(),
                entity.getRouteCode(),
                entity.getOrigin(),
                entity.getDestination(),
                entity.getPlannedStartTime(),
                entity.getPlannedEndTime(),
                entity.getActualStartTime(),
                entity.getActualEndTime(),
                entity.getStatus()
        );
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public RouteJpaEntity toEntity(Route domain) {
        if (domain == null) {
            return null;
        }
        RouteJpaEntity entity = new RouteJpaEntity();
        entity.setId(domain.getId());
        entity.setRouteCode(domain.getRouteCode());
        entity.setOrigin(domain.getOrigin());
        entity.setDestination(domain.getDestination());
        entity.setPlannedStartTime(domain.getPlannedStartTime());
        entity.setPlannedEndTime(domain.getPlannedEndTime());
        entity.setActualStartTime(domain.getActualStartTime());
        entity.setActualEndTime(domain.getActualEndTime());
        entity.setStatus(domain.getStatus());
        return entity;
    }
}
