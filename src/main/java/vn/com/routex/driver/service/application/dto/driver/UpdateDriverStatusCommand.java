package vn.com.routex.driver.service.application.dto.driver;

import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;

public record UpdateDriverStatusCommand(
        String driverId,
        DriverStatus status,
        OperationStatus operationStatus
) {
}
