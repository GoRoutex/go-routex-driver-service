package vn.com.routex.driver.service.domain.vehicle.port;


import vn.com.routex.driver.service.domain.vehicle.model.VehicleProfile;

import java.util.List;
import java.util.Optional;

public interface VehicleProfileRepositoryPort {
    boolean existsByVehiclePlate(String vehiclePlate);

    boolean existsByVehiclePlate(String vehiclePlate, String merchantId);

    Optional<VehicleProfile> findById(String id);

    Optional<VehicleProfile> findById(String id, String merchantId);

    List<VehicleProfile> findByMerchantId(String merchantId);

    void save(VehicleProfile vehicleProfile);

}
