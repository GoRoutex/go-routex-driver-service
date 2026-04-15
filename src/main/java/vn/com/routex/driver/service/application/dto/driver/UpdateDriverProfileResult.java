package vn.com.routex.driver.service.application.dto.driver;

import lombok.Builder;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;

import java.time.LocalDate;

@Builder
public record UpdateDriverProfileResult(
        String driverId,
        String employeeCode,
        String emergencyContactName,
        String emergencyContactPhone,
        DriverStatus status,
        String licenseNumber,
        String licenseClass,
        LocalDate licenseIssueDate,
        LocalDate licenseExpiryDate,
        Integer pointsDelta,
        String pointsReason,
        Boolean kycVerified,
        Boolean trainingCompleted,
        String note
) {
}
