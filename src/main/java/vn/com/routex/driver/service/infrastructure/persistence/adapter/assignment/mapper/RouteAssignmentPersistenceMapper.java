package vn.com.routex.driver.service.infrastructure.persistence.adapter.assignment.mapper;

import org.springframework.stereotype.Component;
import vn.com.routex.driver.service.domain.assignment.model.TripAssignmentRecord;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.assignment.entity.TripAssignmentEntity;

@Component
public class RouteAssignmentPersistenceMapper {
    public TripAssignmentRecord toDomain(TripAssignmentEntity entity) {
        if (entity == null) {
            return null;
        }

        return TripAssignmentRecord.builder()
                .id(entity.getId())
                .merchantId(entity.getMerchantId())
                .tripId(entity.getTripId())
                .creator(entity.getCreator())
                .vehicleId(entity.getVehicleId())
                .driverId(entity.getDriverId())
                .assignedAt(entity.getAssignedAt())
                .unAssignedAt(entity.getUnAssignedAt())
                .ticketPrice(entity.getTicketPrice())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

    public TripAssignmentEntity toEntity(TripAssignmentRecord domain) {
        if (domain == null) {
            return null;
        }
        return TripAssignmentEntity.builder()
                .id(domain.getId())
                .merchantId(domain.getMerchantId())
                .tripId(domain.getTripId())
                .creator(domain.getCreator())
                .vehicleId(domain.getVehicleId())
                .driverId(domain.getDriverId())
                .assignedAt(domain.getAssignedAt())
                .unAssignedAt(domain.getUnAssignedAt())
                .status(domain.getStatus())
                .ticketPrice(domain.getTicketPrice())
                .createdAt(domain.getCreatedAt())
                .createdBy(domain.getCreatedBy())
                .updatedAt(domain.getUpdatedAt())
                .updatedBy(domain.getUpdatedBy())
                .build();
    }
}
