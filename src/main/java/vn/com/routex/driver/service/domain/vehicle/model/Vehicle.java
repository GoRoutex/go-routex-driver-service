package vn.com.routex.driver.service.domain.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.routex.driver.service.domain.shared.model.AbstractAuditingEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends AbstractAuditingEntity {

    private String id;

    private VehicleStatus status;

    private VehicleType type;

    private String vehiclePlate;

    private Integer seatCapacity;

    private String manufacturer;
}
