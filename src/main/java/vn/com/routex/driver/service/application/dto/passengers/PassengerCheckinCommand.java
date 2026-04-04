package vn.com.routex.driver.service.application.dto.passengers;

import lombok.Builder;
import vn.com.routex.driver.service.application.dto.base.RequestContext;


@Builder
public record PassengerCheckinCommand(
        RequestContext context,
        String ticketId,
        String performedBy,
        String deviceId
) {
}
