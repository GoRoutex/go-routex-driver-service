package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.stoppoint.model.RouteStop;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.RouteStopJpaEntity;

@UtilityClass
public class RouteStopPersistenceMapper {
    public RouteStop toDomain(RouteStopJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        RouteStop domain = RouteStop.builder()
                .id(entity.getId())
                .routeId(entity.getRouteId())
                .stopPointId(entity.getStopPointId())
                .stopOrder(entity.getStopOrder())
                .plannedArrivalTime(entity.getPlannedArrivalTime())
                .plannedDepartureTime(entity.getPlannedDepartureTime())
                .actualArrivalTime(entity.getActualArrivalTime())
                .actualDepartureTime(entity.getActualDepartureTime())
                .note(entity.getNote())
                .build();
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public RouteStopJpaEntity toEntity(RouteStop domain) {
        if (domain == null) {
            return null;
        }
        return RouteStopJpaEntity.builder()
                .id(domain.getId())
                .routeId(domain.getRouteId())
                .stopPointId(domain.getStopPointId())
                .stopOrder(domain.getStopOrder())
                .plannedArrivalTime(domain.getPlannedArrivalTime())
                .plannedDepartureTime(domain.getPlannedDepartureTime())
                .actualArrivalTime(domain.getActualArrivalTime())
                .actualDepartureTime(domain.getActualDepartureTime())
                .note(domain.getNote())
                .build();
    }
}
