package vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.assignment.model.RouteAssignment;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.entity.RouteAssignmentEntityAbstract;

@UtilityClass
public class RouteAssignmentPersistenceMapper {
    public RouteAssignment toDomain(RouteAssignmentEntityAbstract entity) {
        if (entity == null) {
            return null;
        }
        return new RouteAssignment(
                entity.getId(),
                entity.getRouteId(),
                entity.getDriverId(),
                entity.getVehicleId(),
                entity.getAssignedAt(),
                entity.getUnAssignedAt(),
                entity.getStatus()
        );
    }

    public RouteAssignmentEntityAbstract toEntity(RouteAssignment domain) {
        if (domain == null) {
            return null;
        }
        RouteAssignmentEntityAbstract entity = new RouteAssignmentEntityAbstract();
        entity.setId(domain.getId());
        entity.setRouteId(domain.getRouteId());
        entity.setVehicleId(domain.getVehicleId());
        entity.setDriverId(domain.getDriverId());
        entity.setAssignedAt(domain.getAssignedAt());
        entity.setUnAssignedAt(domain.getUnAssignedAt());
        entity.setStatus(domain.getStatus());
        return entity;
    }
}
