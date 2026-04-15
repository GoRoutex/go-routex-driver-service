package vn.com.routex.driver.service.application.dto.driver;

import lombok.Builder;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;

@Builder
public record CreateDriverProfileResult(
        String userId,
        String driverCode,
        String employeeCode,
        String currentRouteId,
        String emergencyContactName,
        String emergencyContactPhone,
        DriverStatus status,
        OperationStatus operationStatus,
        Double rating,
        Integer totalTrips,
        String licenseClass,
        String licenseNumber,
        String licenseIssueDate,
        String licenseExpiryDate,
        Integer pointsDelta,
        String pointsReason,
        Boolean kycVerified,
        Boolean trainingCompleted,
        String note
) {
}
