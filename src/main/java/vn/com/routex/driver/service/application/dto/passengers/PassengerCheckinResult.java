package vn.com.routex.driver.service.application.dto.passengers;


import lombok.Builder;
import vn.com.routex.driver.service.domain.booking.BookingSeatStatus;

import java.time.OffsetDateTime;

@Builder
public record PassengerCheckinResult(
    String ticketCode,
    String customerName,
    String seatNumber,
    String routeCode,
    BookingSeatStatus status,
    OffsetDateTime checkedInAt
) {
}
