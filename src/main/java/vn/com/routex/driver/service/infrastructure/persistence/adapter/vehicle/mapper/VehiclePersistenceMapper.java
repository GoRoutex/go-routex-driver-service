package vn.com.routex.driver.service.infrastructure.persistence.adapter.vehicle.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.vehicle.model.Vehicle;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.vehicle.entity.VehicleEntityAbstract;

@UtilityClass
public class VehiclePersistenceMapper {
    public Vehicle toDomain(VehicleEntityAbstract entity) {
        if (entity == null) {
            return null;
        }
        Vehicle domain = new Vehicle(
                entity.getId(),
                entity.getStatus(),
                entity.getType(),
                entity.getVehiclePlate(),
                entity.getSeatCapacity(),
                entity.getManufacturer()
        );
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public VehicleEntityAbstract toEntity(Vehicle domain) {
        if (domain == null) {
            return null;
        }
        VehicleEntityAbstract entity = new VehicleEntityAbstract();
        entity.setId(domain.getId());
        entity.setStatus(domain.getStatus());
        entity.setType(domain.getType());
        entity.setVehiclePlate(domain.getVehiclePlate());
        entity.setSeatCapacity(domain.getSeatCapacity());
        entity.setManufacturer(domain.getManufacturer());
        return entity;
    }
}
