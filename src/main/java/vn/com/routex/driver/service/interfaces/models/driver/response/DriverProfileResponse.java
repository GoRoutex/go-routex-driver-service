package vn.com.routex.driver.service.interfaces.models.driver.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.model.DriverStatus;
import vn.com.routex.driver.service.domain.driver.model.OperationStatus;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@SuperBuilder
public class DriverProfileResponse extends BaseResponse<DriverProfileResponse.DriverProfileResponseData> {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class DriverProfileResponseData {
        private String driverId;
        private String driverCode;
        private String userId;
        private String fullName;
        private String phone;
        private String email;
        private DriverStatus status;
        private OperationStatus operationStatus;
        private String availability;
        private String vehicleCode;
        private String routeId;
        private String shiftId;
        private String depotId;
        private String avatarUrl;
        private Integer points;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
    }

}
