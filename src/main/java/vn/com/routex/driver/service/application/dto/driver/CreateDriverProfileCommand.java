package vn.com.routex.driver.service.application.dto.driver;

import vn.com.routex.driver.service.domain.driver.model.DriverStatus;

import java.time.LocalDate;

public record CreateDriverProfileCommand(
        String userId,
        String currentRouteId,
        String employeeCode,
        String emergencyContactName,
        String emergencyContactPhone,
        DriverStatus status,
        double rating,
        int totalTrips,
        String licenseClass,
        String licenseNumber,
        LocalDate licenseIssueDate,
        LocalDate licenseExpiryDate,
        int pointsDelta,
        String pointsReason,
        boolean kycVerified,
        boolean trainingCompleted,
        String note
) {
}
