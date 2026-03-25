package vn.com.routex.driver.service.interfaces.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.application.dto.driver.CreateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.DeleteDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.GetDriverProfileQuery;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverProfileCommand;
import vn.com.routex.driver.service.application.dto.driver.UpdateDriverStatusCommand;
import vn.com.routex.driver.service.application.services.common.UseCaseException;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DeleteProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateDriverStatusRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

import java.time.LocalDate;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.INVALID_INPUT_ERROR;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.INVALID_INPUT_MESSAGE;

@UtilityClass
public class DriverProfileApiMapper {

    public CreateDriverProfileCommand toCommand(CreateProfileRequest request) {
        var data = request.getData();
        return new CreateDriverProfileCommand(
                data.getUserId(),
                data.getCurrentRouteId(),
                data.getEmployeeCode(),
                data.getEmergencyContactName(),
                data.getEmergencyContactPhone(),
                parseEnum(DriverStatus.class, data.getStatus()),
                data.getRating(),
                data.getTotalTrips(),
                data.getLicenseClass(),
                data.getLicenseNumber(),
                parseLocalDate(data.getLicenseIssueDate()),
                parseLocalDate(data.getLicenseExpiryDate()),
                data.getPointsDelta(),
                data.getPointsReason(),
                data.isKycVerified(),
                data.isTrainingCompleted(),
                data.getNote()
        );
    }

    public UpdateDriverProfileCommand toCommand(UpdateProfileRequest request) {
        var data = request.getData();
        DriverStatus status = null;
        if (data.getStatus() != null && !data.getStatus().isBlank()) {
            status = parseEnum(DriverStatus.class, data.getStatus());
        }
        return new UpdateDriverProfileCommand(
                data.getDriverId(),
                data.getEmployeeCode(),
                data.getEmergencyContactName(),
                data.getEmergencyContactPhone(),
                status,
                data.getLicenseClass(),
                data.getLicenseNumber(),
                parseLocalDate(data.getLicenseIssueDate()),
                parseLocalDate(data.getLicenseExpiryDate()),
                data.getPointsDelta(),
                data.getPointsReason(),
                data.getKycVerified(),
                data.getTrainingCompleted(),
                data.getNote()
        );
    }

    public DeleteDriverProfileCommand toCommand(DeleteProfileRequest request) {
        return new DeleteDriverProfileCommand(request.getData().getDriverId());
    }

    public UpdateDriverStatusCommand toCommand(UpdateDriverStatusRequest request) {
        var data = request.getData();
        DriverStatus status = null;
        OperationStatus operationStatus = null;

        if (data.getStatus() != null && !data.getStatus().isBlank()) {
            status = parseEnum(DriverStatus.class, data.getStatus());
        }
        if (data.getOperationStatus() != null && !data.getOperationStatus().isBlank()) {
            operationStatus = parseEnum(OperationStatus.class, data.getOperationStatus());
        }
        return new UpdateDriverStatusCommand(data.getDriverId(), status, operationStatus);
    }

    public GetDriverProfileQuery toQuery(DriverProfileRequest request) {
        return new GetDriverProfileQuery(request.getData().getDriverId());
    }

    private static LocalDate parseLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            throw new UseCaseException(INVALID_INPUT_ERROR, INVALID_INPUT_MESSAGE);
        }
    }

    private static <T extends Enum<T>> T parseEnum(Class<T> type, String value) {
        try {
            return Enum.valueOf(type, value);
        } catch (Exception e) {
            throw new UseCaseException(INVALID_INPUT_ERROR, INVALID_INPUT_MESSAGE);
        }
    }
}
