package vn.com.routex.driver.service.application.dto.driver;

import lombok.Builder;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;

@Builder
public record UpdateDriverStatusResult(
        String driverId,
        DriverStatus status,
        OperationStatus operationStatus
) {
}
