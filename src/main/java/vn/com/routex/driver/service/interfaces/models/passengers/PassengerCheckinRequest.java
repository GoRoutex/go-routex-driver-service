package vn.com.routex.driver.service.interfaces.models.passengers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PassengerCheckinRequest extends BaseRequest {

    @Valid
    @NotNull
    private PassengerCheckinRequestData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class PassengerCheckinRequestData {
        private String ticketId;
        private String performedBy;
        private String deviceId;
    }
}
