package vn.com.routex.driver.service.infrastructure.persistence.adapter.driver.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.shared.mapper.AuditPersistenceMapper;
import vn.com.routex.driver.service.infrastructure.persistence.jpa.driver.entity.DriverProfileEntityAbstract;

@UtilityClass
public class DriverProfilePersistenceMapper {
    public DriverProfile toDomain(DriverProfileEntityAbstract entity) {
        if (entity == null) {
            return null;
        }
        DriverProfile domain = DriverProfile.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .currentRouteId(entity.getCurrentRouteId())
                .employeeCode(entity.getEmployeeCode())
                .emergencyContactName(entity.getEmergencyContactName())
                .emergencyContactPhone(entity.getEmergencyContactPhone())
                .status(entity.getStatus())
                .operationStatus(entity.getOperationStatus())
                .rating(entity.getRating())
                .totalTrips(entity.getTotalTrips())
                .licenseClass(entity.getLicenseClass())
                .licenseNumber(entity.getLicenseNumber())
                .licenseIssueDate(entity.getLicenseIssueDate())
                .licenseExpiryDate(entity.getLicenseExpiryDate())
                .pointsDelta(entity.getPointsDelta())
                .pointsReason(entity.getPointsReason())
                .kycVerified(entity.getKycVerified())
                .trainingCompleted(entity.getTrainingCompleted())
                .note(entity.getNote())
                .build();
        AuditPersistenceMapper.toDomain(domain, entity);
        return domain;
    }

    public DriverProfileEntityAbstract toEntity(DriverProfile domain) {
        if (domain == null) {
            return null;
        }
        return DriverProfileEntityAbstract.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .currentRouteId(domain.getCurrentRouteId())
                .employeeCode(domain.getEmployeeCode())
                .emergencyContactName(domain.getEmergencyContactName())
                .emergencyContactPhone(domain.getEmergencyContactPhone())
                .status(domain.getStatus())
                .operationStatus(domain.getOperationStatus())
                .rating(domain.getRating())
                .totalTrips(domain.getTotalTrips())
                .licenseClass(domain.getLicenseClass())
                .licenseNumber(domain.getLicenseNumber())
                .licenseIssueDate(domain.getLicenseIssueDate())
                .licenseExpiryDate(domain.getLicenseExpiryDate())
                .pointsDelta(domain.getPointsDelta())
                .pointsReason(domain.getPointsReason())
                .kycVerified(domain.getKycVerified())
                .trainingCompleted(domain.getTrainingCompleted())
                .note(domain.getNote())
                .build();
    }
}
