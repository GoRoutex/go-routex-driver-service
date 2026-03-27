package vn.com.routex.driver.service.interfaces.mapper;

import lombok.experimental.UtilityClass;
import vn.com.routex.driver.service.application.dto.driver.DriverProfileDetailsView;
import vn.com.routex.driver.service.domain.driver.model.DriverProfile;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DeleteProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateDriverStatusRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DeleteProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateDriverStatusResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import static vn.com.routex.driver.service.application.services.common.ErrorConstant.SUCCESS_CODE;
import static vn.com.routex.driver.service.application.services.common.ErrorConstant.SUCCESS_MESSAGE;

@UtilityClass
public class DriverProfileApiResponseMapper {

    private static ApiResult successResult() {
        return ApiResult.builder().responseCode(SUCCESS_CODE).description(SUCCESS_MESSAGE).build();
    }

    public UpdateProfileResponse toUpdateProfileResponse(UpdateProfileRequest request, DriverProfile profile) {
        return UpdateProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(successResult())
                .data(UpdateProfileResponse.UpdateProfileResponseData.builder()
                        .driverId(profile.getId())
                        .employeeCode(profile.getEmployeeCode())
                        .emergencyContactName(profile.getEmergencyContactName())
                        .emergencyContactPhone(profile.getEmergencyContactPhone())
                        .status(profile.getStatus())
                        .licenseClass(profile.getLicenseClass())
                        .licenseNumber(profile.getLicenseNumber())
                        .licenseIssueDate(profile.getLicenseIssueDate())
                        .licenseExpiryDate(profile.getLicenseExpiryDate())
                        .pointsDelta(profile.getPointsDelta())
                        .pointsReason(profile.getPointsReason())
                        .kycVerified(profile.getKycVerified())
                        .trainingCompleted(profile.getTrainingCompleted())
                        .note(profile.getNote())
                        .build())
                .build();
    }

    public CreateProfileResponse toCreateProfileResponse(CreateProfileRequest request, DriverProfile profile) {
        return CreateProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(successResult())
                .data(CreateProfileResponse.CreateProfileResponseData.builder()
                        .userId(profile.getUserId())
                        .employeeCode(profile.getEmployeeCode())
                        .currentRouteId(profile.getCurrentRouteId())
                        .emergencyContactName(profile.getEmergencyContactName())
                        .emergencyContactPhone(profile.getEmergencyContactPhone())
                        .status(profile.getStatus() != null ? profile.getStatus().name() : null)
                        .operationStatus(profile.getOperationStatus() != null ? profile.getOperationStatus().name() : null)
                        .rating(profile.getRating() != null ? profile.getRating() : 0.0)
                        .totalTrips(profile.getTotalTrips() != null ? profile.getTotalTrips() : 0)
                        .licenseClass(profile.getLicenseClass())
                        .licenseNumber(profile.getLicenseNumber())
                        .licenseIssueDate(profile.getLicenseIssueDate() != null ? profile.getLicenseIssueDate().toString() : null)
                        .licenseExpiryDate(profile.getLicenseExpiryDate() != null ? profile.getLicenseExpiryDate().toString() : null)
                        .pointsDelta(profile.getPointsDelta() != null ? profile.getPointsDelta() : 0)
                        .pointsReason(profile.getPointsReason())
                        .kycVerified(Boolean.TRUE.equals(profile.getKycVerified()))
                        .trainingCompleted(Boolean.TRUE.equals(profile.getTrainingCompleted()))
                        .note(profile.getNote())
                        .build())
                .build();
    }

    public DriverProfileResponse toDriverProfileResponse(DriverProfileRequest request, DriverProfileDetailsView view) {
        return DriverProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(successResult())
                .data(DriverProfileResponse.DriverProfileResponseData.builder()
                        .driverId(view.profile().getId())
                        .userId(view.profile().getUserId())
                        .fullName(view.user().getFullName())
                        .phone(view.user().getPhoneNumber())
                        .email(view.user().getEmail())
                        .status(view.profile().getStatus())
                        .operationStatus(view.profile().getOperationStatus())
                        .points(view.profile().getPointsDelta())
                        .createdAt(view.profile().getCreatedAt())
                        .updatedAt(view.profile().getUpdatedAt())
                        .build())
                .build();
    }

    public DeleteProfileResponse toDeleteProfileResponse(DeleteProfileRequest request, DriverProfile profile) {
        return DeleteProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(successResult())
                .data(DeleteProfileResponse.DeleteProfileResponseData.builder()
                        .driverId(profile.getId())
                        .status(profile.getStatus())
                        .operationStatus(profile.getOperationStatus())
                        .build())
                .build();
    }

    public UpdateDriverStatusResponse toUpdateDriverStatusResponse(UpdateDriverStatusRequest request, DriverProfile profile) {
        return UpdateDriverStatusResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(successResult())
                .data(UpdateDriverStatusResponse.UpdateDriverStatusResponseData.builder()
                        .driverId(profile.getId())
                        .status(profile.getStatus())
                        .operationStatus(profile.getOperationStatus())
                        .build())
                .build();
    }
}
