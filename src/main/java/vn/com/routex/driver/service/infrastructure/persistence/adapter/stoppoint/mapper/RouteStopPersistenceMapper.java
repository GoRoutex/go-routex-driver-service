package vn.com.routex.driver.service.infrastructure.persistence.adapter.stoppoint.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.routestop.model.RouteStopPlan;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.stoppoint.entity.RouteStopEntity;

@UtilityClass
public class RouteStopPersistenceMapper {
    public RouteStopPlan toDomain(RouteStopEntity entity) {
        if (entity == null) {
            return null;
        }
        RouteStopPlan domain = RouteStopPlan.builder()
                .id(entity.getId())
                .routeId(entity.getRouteId())
                .creator(entity.getCreator())
                .stopOrder(Integer.parseInt(entity.getStopOrder()))
                .plannedArrivalTime(entity.getPlannedArrivalTime())
                .plannedDepartureTime(entity.getPlannedDepartureTime())
                .note(entity.getNote())
                .operationPointId(entity.getOperationPointId())
                .stopName(entity.getStopName())
                .stopAddress(entity.getStopAddress())
                .stopCity(entity.getStopCity())
                .stopLatitude(entity.getStopLatitude())
                .stopLongitude(entity.getStopLongitude())
                .build();

        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public RouteStopEntity toEntity(RouteStopPlan domain) {
        if (domain == null) {
            return null;
        }
        return RouteStopEntity.builder()
                .id(domain.getId())
                .routeId(domain.getRouteId())
                .creator(domain.getCreator())
                .stopOrder(String.valueOf(domain.getStopAddress()))
                .plannedArrivalTime(domain.getPlannedArrivalTime())
                .plannedDepartureTime(domain.getPlannedDepartureTime())
                .note(domain.getNote())
                .operationPointId(domain.getOperationPointId())
                .stopName(domain.getStopName())
                .stopAddress(domain.getStopAddress())
                .stopCity(domain.getStopCity())
                .stopLatitude(domain.getStopLatitude())
                .stopLongitude(domain.getStopLongitude())
                .build();
    }
}
