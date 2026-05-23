package vn.com.routex.driver.service.domain.vehicle.port;


import vn.com.routex.driver.service.domain.vehicle.model.VehicleProfile;

import java.util.Optional;

public interface VehicleRepositoryPort {
    Optional<VehicleProfile> findById(String vehicleId);

    void save(VehicleProfile vehicle);

    Optional<VehicleProfile> findById(String vehicleId, String merchantId);
}
