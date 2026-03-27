package vn.com.routex.driver.service.application.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.dto.driver.CreateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DeleteDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DriverProfileDetailsView;
import vn.com.routex.driver.service.application.dto.driver.GetDriverProfileQuery;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverStatusCommand;
import vn.com.routex.driver.service.application.services.DriverProfileService;
import vn.com.routex.driver.service.application.services.common.UseCaseException;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;
import vn.com.routex.driver.service.domain.driver.port.DriverProfileRepositoryPort;
import vn.com.routex.driver.service.domain.shared.port.IdGeneratorPort;
import vn.com.routex.driver.service.domain.user.model.User;
import vn.com.routex.driver.service.domain.user.port.UserRepositoryPort;

import java.time.Clock;
import java.time.LocalDateTime;

import static vn.com.routex.driver.service.application.services.common.ErrorConstant.DRIVER_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.DUPLICATE_ERROR;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.RECORD_EXISTS;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.RECORD_NOT_FOUND;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.RECORD_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverProfileServiceImpl implements DriverProfileService {

    private final DriverProfileRepositoryPort driverProfileRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final IdGeneratorPort idGeneratorPort;
    private final Clock clock;

    @Override
    public DriverProfile create(CreateDriverProfileCommand command) {
        if (driverProfileRepositoryPort.findByUserId(command.userId()).isPresent()) {
            throw new UseCaseException(DUPLICATE_ERROR, RECORD_EXISTS);
        }

        DriverProfile driver = DriverProfile.builder()
                .id(idGeneratorPort.newId())
                .userId(command.userId())
                .currentRouteId(command.currentRouteId() != null ? command.currentRouteId() : "")
                .employeeCode(command.employeeCode())
                .emergencyContactName(command.emergencyContactName())
                .emergencyContactPhone(command.emergencyContactPhone())
                .status(command.status())
                .operationStatus(OperationStatus.AVAILABLE)
                .rating(command.rating())
                .totalTrips(command.totalTrips())
                .licenseClass(command.licenseClass())
                .licenseNumber(command.licenseNumber())
                .licenseIssueDate(command.licenseIssueDate())
                .licenseExpiryDate(command.licenseExpiryDate())
                .pointsDelta(command.pointsDelta())
                .pointsReason(command.pointsReason() != null ? command.pointsReason() : "")
                .kycVerified(command.kycVerified())
                .trainingCompleted(command.trainingCompleted())
                .note(command.note() != null ? command.note() : "")
                .build();

        return driverProfileRepositoryPort.save(driver);
    }

    @Override
    public DriverProfile update(UpdateDriverProfileCommand command) {
        DriverProfile profile = driverProfileRepositoryPort.findById(command.driverId())
                .orElseThrow(() -> new UseCaseException(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE));

        if (command.employeeCode() != null) {
            profile.setEmployeeCode(command.employeeCode());
        }
        profile.setEmergencyContactName(command.emergencyContactName());
        profile.setEmergencyContactPhone(command.emergencyContactPhone());
        profile.setLicenseNumber(command.licenseNumber());
        profile.setLicenseClass(command.licenseClass());
        profile.setLicenseIssueDate(command.licenseIssueDate());
        profile.setLicenseExpiryDate(command.licenseExpiryDate());
        if (command.pointsDelta() != null) {
            profile.setPointsDelta(command.pointsDelta());
        }
        if (command.pointsReason() != null) {
            profile.setPointsReason(command.pointsReason());
        }
        if (command.kycVerified() != null) {
            profile.setKycVerified(command.kycVerified());
        }
        if (command.trainingCompleted() != null) {
            profile.setTrainingCompleted(command.trainingCompleted());
        }
        if (command.note() != null) {
            profile.setNote(command.note());
        }
        if (command.status() != null) {
            profile.setStatus(command.status());
        }
        profile.setUpdatedAt(LocalDateTime.now(clock));

        return driverProfileRepositoryPort.save(profile);
    }


    @Override
    public DriverProfile delete(DeleteDriverProfileCommand command) {
        DriverProfile profile = driverProfileRepositoryPort.findById(command.driverId())
                .orElseThrow(() -> new UseCaseException(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE));

        if (DriverStatus.DELETED.equals(profile.getStatus())) {
            return profile;
        }

        profile.setStatus(DriverStatus.DELETED);
        profile.setOperationStatus(OperationStatus.NOT_AVAILABLE);
        profile.setUpdatedAt(LocalDateTime.now(clock));

        return driverProfileRepositoryPort.save(profile);
    }

    @Override
    public DriverProfile updateStatus(UpdateDriverStatusCommand command) {
        DriverProfile profile = driverProfileRepositoryPort.findById(command.driverId())
                .orElseThrow(() -> new UseCaseException(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE));

        if (command.status() != null) {
            profile.setStatus(command.status());
        }
        if (command.operationStatus() != null) {
            profile.setOperationStatus(command.operationStatus());
        }
        profile.setUpdatedAt(LocalDateTime.now(clock));
        return driverProfileRepositoryPort.save(profile);
    }

    @Override
    public DriverProfileDetailsView get(GetDriverProfileQuery query) {
        DriverProfile profile = driverProfileRepositoryPort.findById(query.driverId())
                .orElseThrow(() -> new UseCaseException(RECORD_NOT_FOUND, DRIVER_NOT_FOUND_MESSAGE));

        User user = userRepositoryPort.findById(profile.getUserId())
                .orElseThrow(() -> new UseCaseException(RECORD_NOT_FOUND, DRIVER_NOT_FOUND_MESSAGE));

        return new DriverProfileDetailsView(profile, user);
    }
}
